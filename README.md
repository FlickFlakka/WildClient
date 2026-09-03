# Wild — reconstructed client source

This is a working, buildable source reconstruction of **Wild**, a Fabric client mod for
Minecraft 1.21.8. It was rebuilt from decompiled, obfuscated bytecode — there is no
original human-written source available, so this repo *is* the closest thing to it that
exists. It compiles cleanly, packages into a real Fabric mod jar, and runs.

## What this actually is

The shipped Wild jar was obfuscated (ProGuard-style) before distribution — every
field/method/local name was stripped and replaced with short garbage strings like
`UuUVuuUu`, `C00OOC00oO`. This repo started as a CFR decompilation of that obfuscated
bytecode, which reconstructs valid Java *structure* but can't recover the *original
names* — those were destroyed before decompilation ever happened.

From there, this repo went through several passes to make it into something usable:

1. **Made it compile.** The raw decompiled output had ~50+ recurring decompiler bugs
   (definite-assignment errors from CFR's ternary/switch handling, self-reference-before-
   assignment bugs, mangled try-with-resources blocks, dead static initializers, etc.)
   across dozens of files. All fixed with zero behavioral changes. Two files
   (`BrowserOverlayRenderer`, `AutoBuyModule`) needed real fixes rather than mechanical
   ones — see Notes below for the MCEF situation.
2. **Made it a real Fabric mod**, not just compiled `.class` files. Pulled in
   `fabric.mod.json`, the Mixin config + refmap, the `META-INF` manifest/nested jars, and
   all runtime assets (`resources/`), and fixed a stale entrypoint reference and a mixin
   compile flag issue that meant nothing in the client ever actually ran at load time
   (see Notes).
3. **Renamed ~253 recurring obfuscated identifiers** (`UuUVuuUu`, `C00OOC00oO`, and
   everything like them) to plain, distinct, readable names across all 873 files —
   roughly 133,500 individual renames. This was done as a whole-codebase, string/comment-
   aware, scope-safe token substitution (Java resolves identifiers lexically, so a
   *consistent* global rename can't break compilation) rather than by hand.
4. **Added a first-launch Discord verification flow** (`DiscordAuthManager`) as a
   requested feature — see Notes.

## Important: what "readable" means here

The renamed identifiers are **not semantically accurate** — the original names are gone
for good, so there was no way to recover what a given field or method was *actually*
supposed to be called. What you get instead is: every occurrence of the same gibberish
token now reads as the same plain, distinct word (e.g. `UuUVuuUu` → `primaryVal`
everywhere), so the code no longer looks like line noise and different concepts are at
least visually distinguishable from each other — but a name like `primaryVal` doesn't
tell you what it does beyond what the surrounding code shows you. Treat this as "no
longer obfuscated garbage," not "cleanly documented."

## Build

Requirements: JDK 21+ (`javac` on PATH, or `JAVA_HOME` set). Nothing else — every
third-party/Minecraft/Fabric/Mixin jar this needs is vendored in `lib/` (302 jars, ~190
MB), so the build has no dependency on any local Minecraft/Gradle install.

```
python build.py            # compiles to build/classes and packages build/wild.jar
python build.py noJar      # compile only, skip the jar
```

or on Windows, double-click / run `build.bat`.

`build.py` also runs `patch_mixin_super.py` automatically after every compile — see
Notes for why that's necessary.

## Installing / running

`build/wild.jar` is a real Fabric mod — copy it into `.minecraft/mods/`. Requires Fabric
Loader ≥0.18.4 and Fabric API on Minecraft 1.21.8. It does nothing run standalone
(`java -jar wild.jar`) — it only runs loaded inside a Fabric-modded client.

**First launch requires a one-time Discord verification** (see Notes) before the client
becomes usable — the game will pop a dialog with a login URL and wait up to 5 minutes for
it to complete, then never asks again.

## Layout

- `src/` — all 873 `.java` sources, package layout intact (`org/`, `ru/metaculture/...`,
  `dev/`, ...).
- `lib/` — vendored compile-time dependencies (Minecraft 1.21.8 intermediary jar, Fabric
  API + loader, Mixin/SpongePowered, ViaVersion, an MCEF compile-only stub since no
  official MCEF build targets 1.21.8, and the rest of the classpath).
- `resources/` — everything the compiled classes need to actually run as a Fabric mod,
  bundled into `build/wild.jar` alongside the `.class` files:
  - `fabric.mod.json` — mod manifest (id, entrypoint, mixin config, depends).
  - `wild_mixins.json` + `Wild-refmap.json` — the Mixin config and refmap. This is how
    Wild hooks into Minecraft's render/input/tick loop, including the click-gui.
  - `META-INF/MANIFEST.MF` — declares `Fabric-Mapping-Namespace: intermediary` so
    Fabric Loader remaps the mod's `class_XXXX`/`method_XXXX` calls at load time.
  - `META-INF/jars/*.jar` — 10 runtime dependencies loaded via Fabric's jar-in-jar
    mechanism (baritone, Java-WebSocket, javassist, jlayer/mp3spi/tritonus for audio,
    json, netty extras, reflections).
  - `assets/` — textures, fonts, shaders for the click-gui/HUD, plus native libs.
- `build.py` / `build.bat` — self-contained build script; nothing outside this folder is
  referenced.
- `patch_mixin_super.py` — post-compile bytecode patch, see Notes.

## Notes / known issues

- **MCEF (in-game browser) is a stub.** No official MCEF build exists for Minecraft
  1.21.8, so `lib/` contains a compile-only stub covering just the API surface Wild
  calls. `BrowserOverlayRenderer` compiles and loads fine, but the actual embedded
  browser won't render anything until a real MCEF 1.21.8 build exists upstream.
- **Mixin superclass bytecode patch is required.** 13 of Wild's mixin classes use a real,
  documented Mixin pattern — extending their own `@Mixin` target for typed access to
  protected members. Normally SpongePowered Mixin's annotation processor rewrites that to
  `java.lang.Object` at compile time; this build compiles with `-proc:none` (no
  annotation processing), so `patch_mixin_super.py` does that exact rewrite directly on
  the compiled `.class` files after every build. Without it, Mixin's runtime transformer
  rejects those 13 classes ("Super class X of Mixin was not found in the hierarchy of
  target class X") and nothing that depends on them — including the whole click-gui menu
  — ever loads.
- **Discord verification (`DiscordAuthManager`) is a feature added during
  reconstruction**, not something recovered from the original. On first launch it opens
  a browser to a Discord OAuth2 page (implicit grant — no client secret ships in the
  jar), waits for you to approve, fetches your Discord username + avatar via a local
  callback server, caches them, and applies your avatar/name in the client's diagnostics
  panel. It also opens an invite to a specific Discord server as part of that same
  one-time flow. This is a *hard requirement* — if it's never completed, the game
  terminates rather than continuing unverified. If you fork this for your own use, you'll
  need to swap in your own Discord Application Client ID (`DiscordAuthManager.java`,
  `CLIENT_ID`) and register `http://localhost:47113/callback` as an OAuth2 redirect URI
  in Discord's Developer Portal for it to work at all.
- `fabric.mod.json`'s entrypoint originally pointed at `ru.metaculture.protection.NVnVnNnN`
  (the obfuscated name from the shipped jar); the class was renamed to `WildClient`
  during reconstruction but the manifest wasn't updated to match, so Fabric Loader never
  actually called into the mod. Fixed.
- This repo has no Gradle/Loom dev environment (no `run-client` task) — `build.py` only
  compiles the source and packages a droppable mod jar.

## Credits

Source obtained/reconstructed by Uelm & Claude.
