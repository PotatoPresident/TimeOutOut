# TimeOut Out (Fabric)

This mod is the connection timeout configuration from [Random Patches](https://github.com/TheRandomLabs/RandomPatches) standalone because it hasn't updated to 1.18.

Read the [Random Patches README](https://github.com/TheRandomLabs/RandomPatches) for full config information.  
Also hopefully the maintainer will start updating the mod again and this project will be allowed to die.

## Features

Features without a specified side are server-sided.

### Connection timeouts

In vanilla Minecraft, the connection timeouts are hardcoded, and often not long enough for
slower computers or heavier modded instances. To counter this, TimeOutOut allows several
connection timeouts to be configured:

* The connection read timeout
    * Both client and server-sided
    * Raised to 120 seconds from the vanilla value of 30 seconds by default
* The login timeout
    * How long the server waits for a player to log in
    * Raised to 2400 ticks (120 seconds) from the vanilla value of 600 ticks (30 seconds) by default
* The KeepAlive timeout
    * How long the server waits for a player to return a KeepAlive packet before disconnecting them
    * Raised to 120 seconds from the vanilla value of 30 seconds by default

In addition, RandomPatches allows the interval at which KeepAlive packets are sent to clients
to be configured, although it is recommended that this be left at the vanilla value of 15 seconds.

## Download

* You can directly download from [Releases page on Github](https://github.com/houby-studio/TimeOutOut/releases/latest)
* You can also download from [CurseForge](https://www.curseforge.com/minecraft/mc-mods/timeoutout-fabric)