# Wild: reconstructed client source

So the Wild devs ran their jar through an obfuscator, scrambled every field and method
name into garbage like `UuUVuuUu` and `C00OOC00oO`, and presumably called it a day:
mission accomplished, source protected, nobody's reading this. Cute plan. It held up for
about as long as it takes to point a decompiler at the jar and start reading.

This repo is the result: a full working reconstruction of Wild's client source, rebuilt
from that same obfuscated bytecode, with the garbage names cleaned up, the decompiler's
own mistakes fixed, and the whole thing wired back together into a mod that actually
loads and runs. Turns out "obfuscated" and "safe" were never the same word.

## How this actually got made

Whatever build pipeline shipped Wild ran everything through a ProGuard-style obfuscator
before release, so every field, method, and local variable in the compiled jar got
replaced with short meaningless strings. There's no original source sitting around
anywhere. This repo is rebuilt from what the obfuscator left behind, nothing more.

Getting from "decompiled bytecode" to "thing you can build and run" took a few passes:

- Ran the obfuscated bytecode through CFR to get it back into Java. CFR rebuilds the
  structure fine (control flow, types, method bodies) but it can't recover names that
  were already destroyed before it ever touched the jar. That output was still full of
  the original garbage identifiers.
- Fixed the decompiler's own mistakes. CFR's raw dump had a few dozen recurring bugs
  scattered across the codebase: bad definite-assignment handling around ternaries and
  switches, self-reference-before-assignment errors, mangled try-with-resources blocks,
  dead static initializers. All fixed without changing what the code actually does.
- Turned the compiled classes into something Fabric would actually load. This meant
  pulling in the mod manifest, the mixin config and refmap, nested runtime jars, and all
  the assets, plus fixing a stale entrypoint reference and a mixin compile issue that
  meant the mod jar loaded but never actually did anything.
- Renamed the obfuscated identifiers. About 253 distinct garbage tokens, roughly 133,500
  occurrences, swapped for plain readable names across all 873 files in one big
  scope-safe pass rather than by hand.
- Added a first-launch Discord verification step, which wasn't part of the original and
  is described further down.

Worth being upfront about what the renaming did and didn't accomplish: the original
names are gone permanently, so there was no way to know what a given field was actually
supposed to be called. What happened instead is every occurrence of the same garbage
token got mapped to the same plain word everywhere it showed up, so the code stops
looking like line noise and different things at least look different from each other.
That's the whole deal: readable, not documented.

## Using it

You need a JDK 21+ (`javac` on PATH, or `JAVA_HOME` pointing at one) and nothing else.
Every Minecraft/Fabric/Mixin/third-party jar this needs is already sitting in `lib/`
(302 of them), so the build never touches your local Minecraft install or Gradle cache.

```
python build.py            # compiles to build/classes, packages build/wild.jar
python build.py noJar      # compile only
```

or just run `build.bat` on Windows.

`build.py` runs `patch_mixin_super.py` on the compiled classes right after compiling.
That's not optional, see the notes below for why.

Drop the resulting `build/wild.jar` into `.minecraft/mods/`. You'll need Fabric Loader
0.18.4+ and Fabric API for 1.21.8. Running the jar directly does nothing. It only works
loaded inside an actual modded client.

First launch, you'll hit a Discord verification prompt before anything else works: a
dialog with a login link pops up, you approve it in the browser, and it caches the
result so it never asks again after that.

## What's in here

- `src/`: the 873 `.java` files, packages intact.
- `lib/`: everything needed to compile: the Minecraft 1.21.8 intermediary jar, Fabric
  API/loader, Mixin, ViaVersion, a compile-only MCEF stub, and the rest of the classpath.
- `resources/`: the stuff that has to end up inside the jar for it to work as a mod at
  all: `fabric.mod.json`, the mixin config and refmap, the manifest that tells Fabric
  Loader to remap the mod's intermediary names at load time, ten jar-in-jar runtime
  dependencies, and the assets: textures, fonts, shaders, native libs.
- `build.py` / `build.bat`: the build script. Doesn't reach outside this folder.
- `patch_mixin_super.py`: a post-compile bytecode patch, explained below.

## Things worth knowing before you go digging

MCEF, the in-game browser library Wild uses, has no official build for 1.21.8, so `lib/`
has a compile-only stub covering just enough of its API to build. `BrowserOverlayRenderer`
compiles and loads fine, but the actual embedded browser won't render anything until MCEF
itself catches up to this Minecraft version.

Thirteen of Wild's mixin classes extend their own `@Mixin` target, a real, intentional
Mixin pattern for typed access to protected members. Normally Mixin's annotation
processor rewrites that superclass to `java.lang.Object` at compile time. This build
skips annotation processing entirely, so that rewrite never happens on its own.
`patch_mixin_super.py` does the same rewrite directly on the compiled `.class` files
after the fact. Skip that step and Mixin's runtime transformer refuses to load those 13
classes, and a lot of Wild's UI, including the click-gui menu, depends on them.

The Discord verification thing (`DiscordAuthManager`) isn't recovered from anywhere. It
got added during this reconstruction. On first launch it opens a Discord OAuth2 page in
your browser using the implicit grant flow, so there's no client secret sitting in the
jar for anyone to pull out. It waits for you to approve, pulls your username and avatar
back through a local callback server, caches both, and uses them in the client's
diagnostics panel. It also opens an invite to a specific Discord server as part of that
same flow. None of this is optional. If you don't finish it, the game closes instead of
continuing unverified. If you're forking this for yourself, you'll need to swap in your
own Discord Application Client ID (`DiscordAuthManager.java`, the `CLIENT_ID` constant)
and register `http://localhost:47113/callback` as a redirect URI in Discord's developer
portal, or none of this will work.

`fabric.mod.json` used to point its entrypoint at `ru.metaculture.protection.NVnVnNnN`,
the obfuscated class name from the original jar. That class got renamed to `WildClient`
at some point during reconstruction, but nobody updated the manifest to match, so Fabric
Loader was silently never calling into the mod at all. Fixed now.

There's no Gradle/Loom setup here, so no `run-client` task or dev environment. This just
compiles the source and spits out a jar you can drop into a real client.

## Credits

Source obtained/reconstructed by Uelm & Claude.
