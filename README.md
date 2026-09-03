# Wild — reconstructed client source

Wild is a Fabric client mod for Minecraft 1.21.8. This repo is a working reconstruction
of its source, rebuilt from the obfuscated bytecode it shipped as — there's no original
human-written source floating around anywhere, so this is about as close as it gets. It
compiles, packages into a real mod jar, and runs.

## Backstory

Whatever build system Wild's devs used ran everything through an obfuscator before
shipping, so every field, method, and local variable name in the compiled jar got
replaced with garbage like `UuUVuuUu` or `C00OOC00oO`. This repo started life as a CFR
decompile of that bytecode. CFR can rebuild the structure of the code fine, but it has no
way to recover names that were already destroyed before decompilation even happened.

Getting from "decompiled bytecode" to "thing you can actually build and run" took a few
passes:

- Fixing the decompiler's own output. CFR's raw dump had a few dozen recurring bugs —
  ternary/switch definite-assignment issues, self-reference-before-assignment bugs,
  mangled try-with-resources, dead static initializers, that kind of thing — spread
  across a lot of files. All fixed without changing behavior. Two files needed something
  closer to a real fix than a mechanical one (`BrowserOverlayRenderer` and
  `AutoBuyModule` — see the notes below on MCEF).
- Turning the compiled classes into an actual loadable mod. This meant pulling in
  `fabric.mod.json`, the mixin config and refmap, the manifest and nested jars, and all
  the runtime assets, plus fixing a stale entrypoint reference and a mixin compile issue
  — without those the mod jar just sat there doing nothing at runtime.
- Renaming the obfuscated identifiers. About 253 distinct garbage tokens, roughly 133,500
  occurrences total, swapped out for plain readable names across all 873 files. Done as
  one big scope-safe substitution rather than by hand — see the section below on what
  that does and doesn't get you.
- Bolting on a first-launch Discord verification step, which wasn't part of the original
  and is described further down.

## About the renamed identifiers

Don't mistake "readable" for "documented." The original names are gone for good, so
there was no way to figure out what a given field or method was actually supposed to be
called — nobody kept a symbol table around for a ProGuard'd jar. What actually happened
is every occurrence of a given garbage token got mapped to the same plain word
everywhere (`UuUVuuUu` became `primaryVal` wherever it showed up), so the code stops
looking like line noise and different things at least look different from each other.
That's it. `primaryVal` doesn't tell you what it does beyond what you can already see in
the surrounding code — it's just no longer actively hostile to read.

## Building it

You need a JDK 21+ (`javac` on PATH, or `JAVA_HOME` pointing at one). That's the only
thing you need — every Minecraft/Fabric/Mixin/third-party jar this depends on is already
sitting in `lib/` (302 of them), so the build doesn't touch your local Minecraft
install or Gradle cache at all.

```
python build.py            # compiles to build/classes, packages build/wild.jar
python build.py noJar      # compile only
```

or just run `build.bat` if you're on Windows and don't want to type anything.

`build.py` runs `patch_mixin_super.py` on the compiled classes right after compiling —
that step isn't optional, see the notes below for why.

## Running it

Drop `build/wild.jar` into `.minecraft/mods/`. You'll need Fabric Loader 0.18.4+ and
Fabric API for 1.21.8. It won't do anything if you try to run the jar directly — it only
does anything loaded inside an actual modded client.

First time you launch it, you'll get a Discord verification prompt before anything else
works — a dialog with a login link pops up, you approve it in the browser, and it caches
the result so it never asks again after that.

## What's in here

- `src/` — the 873 `.java` files, packages intact.
- `lib/` — everything needed to compile: the Minecraft 1.21.8 intermediary jar, Fabric
  API/loader, Mixin, ViaVersion, and a compile-only MCEF stub (more on that below), plus
  the rest of the classpath.
- `resources/` — the stuff that has to end up inside the jar for it to work as a mod at
  all: `fabric.mod.json`, the mixin config + refmap, the manifest that tells Fabric
  Loader to remap the mod's intermediary names at load time, ten jar-in-jar runtime
  dependencies, and the assets — textures, fonts, shaders, native libs.
- `build.py` / `build.bat` — the build script. Doesn't reach outside this folder for
  anything.
- `patch_mixin_super.py` — a post-compile bytecode patch, explained below.

## Things worth knowing before you go digging

MCEF, the in-game browser library Wild uses, has no official build for 1.21.8. So
`lib/` has a compile-only stub covering just enough of its API for things to build.
`BrowserOverlayRenderer` will compile and load without complaint, but the actual embedded
browser won't render anything until MCEF itself catches up to this Minecraft version.

Thirteen of Wild's mixin classes extend their own `@Mixin` target — a real, intentional
Mixin pattern used to get typed access to protected members. Normally Mixin's annotation
processor rewrites that superclass to `java.lang.Object` at compile time. This build
skips annotation processing entirely, so that rewrite never happens on its own.
`patch_mixin_super.py` does the same rewrite directly on the compiled `.class` files
after the fact. Skip that step and Mixin's runtime transformer refuses to load those 13
classes, and a lot of Wild's UI — including the click-gui menu — depends on them.

The Discord verification thing (`DiscordAuthManager`) isn't something that was recovered
from anywhere — it got added during this reconstruction. On first launch it opens a
Discord OAuth2 page in your browser using the implicit grant flow, so there's no client
secret sitting in the jar for anyone to pull out. It waits for you to approve, pulls your
username and avatar back through a local callback server, caches both, and uses them in
the client's diagnostics panel. It also opens an invite to a specific Discord server as
part of that same flow. None of this is optional — if you don't finish it, the game
closes instead of continuing unverified.
If you're forking this for yourself, you'll need to swap in your own Discord Application
Client ID (`DiscordAuthManager.java`, the `CLIENT_ID` constant) and register
`http://localhost:47113/callback` as a redirect URI in Discord's developer portal, or
none of this will work.

`fabric.mod.json` used to point its entrypoint at `ru.metaculture.protection.NVnVnNnN` —
the obfuscated class name from the original jar. That class got renamed to `WildClient`
at some point during reconstruction, but nobody updated the manifest to match, so Fabric
Loader was silently never calling into the mod at all. Fixed now.

There's no Gradle/Loom setup here, so no `run-client` task or dev environment — this just
compiles the source and spits out a jar you can drop into a real client.

## Credits

Source obtained/reconstructed by Uelm & Claude.
