<h1 align="center">EzUtils is no longer actively maintained.</h1>

# EzUtils

EzUtils is a simple, easy to use plugin that lets server admins manage plugins from either in-game or console without the need to restart the server.

## Features
* Enable, disable, restart, load, reload, and unload plugins from in-game or console.
* List plugins alphabetically, with version if specified.
* Get useful information on plugins such as commands, version, author(s), etc.
* Easily manage plugins without having to constantly restart your server.
* List commands a plugin has registered.
* Find the plugin a command is registered to.
* Tab completion for command names and plugin names.
* Dump plugin list with versions to a file.
* Check if a plugin is up-to-date with dev.bukkit.org
* Permissions Support - All commands default to OP.

## Commands
| Command | Description |
| --------------- | ---------------- |
| /ezutils help | Show help information. |
| /ezutils list [-v] | List plugins in alphabetical order. Use "-v" to include versions. |
| /ezutils info [plugin] | Displays information about a plugin. |
| /ezutils dump | Dump plugin names and version to a file. |
| /ezutils usage [plugin] | List commands that a plugin has registered. |
| /ezutils lookup [command] | Find the plugin a command is registered to. |
| /ezutils enable [plugin&#124;all] | Enable a plugin. |
| /ezutils disable [plugin&#124;all] | Disable a plugin. |
| /ezutils restart [plugin&#124;all] | Restart (disable/enable) a plugin. |
| /ezutils load [plugin] | Load a plugin. |
| /ezutils reload [plugin&#124;all] | Reload (unload/load) a plugin. |
| /ezutils unload [plugin] | Unload a plugin. |
| /ezutils check [plugin&#124;all] [-f] | Check if a plugin is up-to-date. |
| /ezutils crash [player] [-f] | Crash a player client. |
| /ezutils servercast [messages] [-f] | Server cast. |

## Permissions
| Permission Node | Default | Description |
| ------------------------- | ---------- | ---------------- |
| ezutils.admin | OP | Allows use of all EzUtils commands. |
| ezutils.update | OP | Allows user to see update messages. |
| ezutils.help | OP | Allow use of the help command. |
| ezutils.list | OP | Allow use of the list command. |
| ezutils.info | OP | Allow use of the info command. |
| ezutils.dump | OP | Allow use of the dump command. |
| ezutils.usage | OP | Allow use of the usage command. |
| ezutils.lookup | OP | Allow use of the lookup command. |
| ezutils.enable | OP | Allow use of the enable command. |
| ezutils.enable.all | OP | Allow use of the enable all command. |
| ezutils.disable | OP | Allow use of the disable command. |
| ezutils.disable.all | OP | Allow use of the disable all command. |
| ezutils.restart | OP | Allow use of the restart command. |
| ezutils.restart.all | OP | Allow use of the restart all command. |
| ezutils.load | OP | Allow use of the load command. |
| ezutils.reload | OP | Allow use of the reload command. |
| ezutils.reload.all | OP | Allow use of the reload all command. |
| ezutils.unload | OP | Allow use of the unload command. |
| ezutils.check | OP | Allow use of the check command. |
| ezutils.crash | OP | Allow use of the crash command. |
| ezutils.servercast | OP | Allow use of the servercast command. |
| ezutils.check.all | OP | Allow use of the check command. |

## Configuration
| File | URL |
| ----- | ------- |
| config.yml | https://github.com/NuymakStone/EzUtils/blob/master/src/main/resources/config.yml |

## Sponsors

<div style="text-align:center" markdown="1">

![image](https://raw.githubusercontent.com/NuymakStone/EzUtils/master/images/jetbrains_logo.png "JetBrains")

JetBrains is kindly supporting the EzUtils open source project with it's full-featured Java IDE.

Take a look a JetBrain's leading software products over on <a href="http://www.jetbrains.com/">their website.</a>

---

![image](https://raw.githubusercontent.com/NuymakStone/EzUtils/master/images/yourkit_logo.png "YourKit")

YourKit is kindly supporting the EzUtils open source project with its full-featured Java Profiler.

YourKit, LLC is the creator of innovative and intelligent tools for profiling Java and .NET applications.

Take a look at YourKit's leading software products: <a href="http://www.yourkit.com/java/profiler/index.jsp">YourKit Java Profiler</a> and <a href="http://www.yourkit.com/.net/profiler/index.jsp">YourKit .NET Profiler</a>.

---

![image](https://raw.githubusercontent.com/NuymakStone/EzUtils/master/images/intreppid_logo.png "Intreppid Logo")

Intreppid is kindly supporting the EzUtils open source project with hosting for the Jenkins build server along with a test platform for development.

Take a look at Intreppid's premium Minecraft server and dedicated servers on <a href="https://www.intreppid.com/">their website</a>.
