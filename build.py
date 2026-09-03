"""Self-contained build script for the Wild client source.

Requires: JDK 21+ (javac on PATH, or set JAVA_HOME).
Everything else (all third-party/Minecraft/Fabric jars) is vendored in ./lib.

Usage:
    python build.py            # compile to ./build/classes and package ./build/wild.jar
    python build.py noJar      # compile only, skip packaging the jar
"""
from pathlib import Path
import os
import shutil
import subprocess
import sys
import zipfile

ROOT = Path(__file__).resolve().parent
SRC = ROOT / "src"
LIB = ROOT / "lib"
RESOURCES = ROOT / "resources"
OUT = ROOT / "build" / "classes"


def find_javac() -> str:
    java_home = os.environ.get("JAVA_HOME")
    if java_home:
        candidate = Path(java_home) / "bin" / ("javac.exe" if os.name == "nt" else "javac")
        if candidate.is_file():
            return str(candidate)
    found = shutil.which("javac")
    if found:
        return found
    sys.exit("javac not found. Install JDK 21+ and ensure it's on PATH or set JAVA_HOME.")


def main():
    javac = find_javac()

    sources = sorted(SRC.rglob("*.java"))
    if not sources:
        sys.exit(f"No .java files found under {SRC}")

    jars = sorted(LIB.glob("*.jar"))
    if not jars:
        sys.exit(f"No dependency jars found under {LIB}")
    # forward slashes: javac's @argfile parser treats backslash as an escape
    # character, which mangles Windows paths when they appear unescaped.
    classpath = ";".join(j.as_posix() for j in jars)

    OUT.mkdir(parents=True, exist_ok=True)

    argfile = ROOT / "build" / "sources.txt"
    argfile.parent.mkdir(parents=True, exist_ok=True)
    argfile.write_text("\n".join(f'"{p.as_posix()}"' for p in sources) + "\n", encoding="ascii")

    options = ROOT / "build" / "options.txt"
    options.write_text(
        "\n".join([
            "-proc:none", "--release", "21", "-Xmaxerrs", "10000", "-Xmaxwarns", "10000",
            "-d", f'"{OUT.as_posix()}"',
            "-classpath", f'"{classpath}"',
        ]) + "\n",
        encoding="ascii",
    )

    print(f"Compiling {len(sources)} sources against {len(jars)} jars...")
    result = subprocess.run(
        [javac, f"@{options}", f"@{argfile}"],
        cwd=str(ROOT), text=True,
    )
    if result.returncode != 0:
        sys.exit(f"Build failed (exit={result.returncode}).")

    print(f"Build succeeded. Classes in {OUT}")

    import patch_mixin_super
    patched = 0
    mixin_dir = OUT / "org" / "wild" / "mixin"
    for name in patch_mixin_super.SELF_EXTENDING_MIXINS:
        f = mixin_dir / f"{name}.class"
        if f.is_file():
            f.write_bytes(patch_mixin_super.patch_superclass_to_object(f.read_bytes()))
            patched += 1
    print(f"Patched superclass -> java.lang.Object on {patched}/{len(patch_mixin_super.SELF_EXTENDING_MIXINS)} mixin classes")

    if not (len(sys.argv) > 1 and sys.argv[1] == "noJar"):
        jar_path = ROOT / "build" / "wild.jar"
        with zipfile.ZipFile(jar_path, "w", zipfile.ZIP_DEFLATED) as zf:
            for f in OUT.rglob("*.class"):
                zf.write(f, f.relative_to(OUT))
            # fabric.mod.json, mixin config + refmap, META-INF (manifest + nested
            # runtime jars), assets, and native libs - without these Fabric Loader
            # won't recognize/load the mod at all, and mixins/UI/natives won't work
            # even if it did.
            if RESOURCES.is_dir():
                for f in RESOURCES.rglob("*"):
                    if f.is_file():
                        zf.write(f, f.relative_to(RESOURCES))
            else:
                print(f"WARNING: {RESOURCES} not found - jar will be missing "
                      f"fabric.mod.json/mixins/assets and will NOT load as a mod.")
        print(f"Packaged {jar_path}")


if __name__ == "__main__":
    main()
