"""Post-compile bytecode patch for Mixin classes that `extends` their own @Mixin
target class (a real, documented Mixin pattern used for compile-time type-safe access
to protected members). Normally SpongePowered Mixin's annotation processor rewrites
such a class's compiled superclass to java.lang.Object during compilation, keeping the
`extends` purely a compile-time convenience. This build disables annotation processing
(-proc:none), so the raw compiled superclass stays as the literal target class, which
Mixin's runtime transformer rejects ("Super class X of Mixin was not found in the
hierarchy of target class X"). This script performs the same superclass rewrite the
Mixin AP would have done, directly on the .class file, for exactly the classes that
need it - zero source changes.
"""
from pathlib import Path
import struct
import sys

# simple_name -> package-relative .class path (all in org/wild/mixin)
SELF_EXTENDING_MIXINS = [
    "ChatHudMixin", "ChestScreenMixin", "ClientCommonNetworkHandlerMixin",
    "ClientPlayerEntityMixin", "ClientPlayNetworkHandlerMixin", "EntityMixin",
    "HandledScreenMixin", "KeyboardInputMixin", "LevelLoadingScreenMixin",
    "LivingEntityMixin", "MinecraftClientMixin", "ScreenMixin", "WorldRendererMixin",
]

CONSTANT_SIZES = {
    3: 4, 4: 4, 9: 4, 10: 4, 11: 4, 12: 4,  # Integer/Float/Fieldref/Methodref/IfaceMethodref/NameAndType
    7: 2, 8: 2, 16: 2, 19: 2, 20: 2,        # Class/String/MethodType/Module/Package
    15: 3,                                   # MethodHandle
    17: 4, 18: 4,                            # Dynamic/InvokeDynamic
    5: 8, 6: 8,                              # Long/Double (double-width)
}


def patch_superclass_to_object(data: bytes) -> bytes:
    if data[0:4] != b"\xca\xfe\xba\xbe":
        raise ValueError("not a class file")
    pos = 8  # magic + minor + major
    cp_count = struct.unpack_from(">H", data, pos)[0]
    pos += 2
    entries = {}  # index -> (start, end, tag)
    idx = 1
    while idx < cp_count:
        tag = data[pos]
        start = pos
        if tag == 1:  # Utf8
            length = struct.unpack_from(">H", data, pos + 1)[0]
            end = pos + 3 + length
        elif tag in CONSTANT_SIZES:
            end = pos + 1 + CONSTANT_SIZES[tag]
        else:
            raise ValueError(f"unknown constant tag {tag} at {pos}")
        entries[idx] = (start, end, tag)
        pos = end
        idx += 2 if tag in (5, 6) else 1

    cp_end = pos  # byte offset right after the last constant pool entry

    # find existing Utf8 "java/lang/Object"
    object_utf8_idx = None
    for i, (s, e, tag) in entries.items():
        if tag == 1:
            length = struct.unpack_from(">H", data, s + 1)[0]
            text = data[s + 3:s + 3 + length]
            if text == b"java/lang/Object":
                object_utf8_idx = i
                break

    # find existing Class entry pointing at that Utf8
    object_class_idx = None
    if object_utf8_idx is not None:
        for i, (s, e, tag) in entries.items():
            if tag == 7:
                name_idx = struct.unpack_from(">H", data, s + 1)[0]
                if name_idx == object_utf8_idx:
                    object_class_idx = i
                    break

    extra = b""
    next_idx = cp_count  # next_idx is the count itself since count = highest_index+1
    if object_utf8_idx is None:
        object_utf8_idx = next_idx
        payload = b"java/lang/Object"
        extra += bytes([1]) + struct.pack(">H", len(payload)) + payload
        next_idx += 1
    if object_class_idx is None:
        object_class_idx = next_idx
        extra += bytes([7]) + struct.pack(">H", object_utf8_idx)
        next_idx += 1

    added_entries = next_idx - cp_count
    new_cp_count = cp_count + added_entries

    out = bytearray(data)
    # insert new constant-pool bytes right after the last existing entry
    out[cp_end:cp_end] = extra
    # update constant_pool_count field (at offset 8..10)
    out[8:10] = struct.pack(">H", new_cp_count)

    # after insertion, access_flags/this_class/super_class are shifted by len(extra)
    super_class_off = cp_end + len(extra) + 2 + 2  # +access_flags +this_class
    out[super_class_off:super_class_off + 2] = struct.pack(">H", object_class_idx)

    return bytes(out)


def main():
    if len(sys.argv) < 2:
        sys.exit("usage: patch_mixin_super.py <build/classes dir>")
    classes_dir = Path(sys.argv[1])
    mixin_dir = classes_dir / "org" / "wild" / "mixin"
    patched = 0
    for name in SELF_EXTENDING_MIXINS:
        f = mixin_dir / f"{name}.class"
        if not f.is_file():
            print(f"WARNING: {f} not found, skipping")
            continue
        data = f.read_bytes()
        new_data = patch_superclass_to_object(data)
        f.write_bytes(new_data)
        patched += 1
    print(f"Patched superclass -> java.lang.Object on {patched}/{len(SELF_EXTENDING_MIXINS)} mixin classes")


if __name__ == "__main__":
    main()
