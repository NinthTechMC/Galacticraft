# Galacticraft
This is a reworked fork of Galacticraft 1.7.10 for development use outside of GTNH. I literally
cannot find a dev build anywhere on the internet.

The `official` branch is what was forked and the `main` branch is where I will be making changes.

I don't plan to change anything in the mod outside of making it buildable (with java 8). All changes I made are marked with `// PISTON` comments.

Use of this fork must follow the Galacticraft license. In particular, there's nothing in the release because
distribution of compiled binary is prohibited. If you just want a playable (obfuscated) version, download from [CurseForge](https://www.curseforge.com/minecraft/mc-mods/galacticraft-legacy/files?page=1&pageSize=20&version=1.7.10). If you want a dev build for testing your mod, read along.

## Build
**Make sure you have read important licensing information above.**

**note: currently won't build as I am updating the mcmod tool**

You need my [mcmod](https://github.com/NinthTechMC/mcmod) tool for building this mod. Optionally, you need [magoo](https://github.com/Pistonite/magoo).

1. `cd` to the repo you cloned
2. `magoo install` (`git submodule update --init` if you don't have magoo)
3. `mcmod -C dependencies build`
4. `mcmod build`
