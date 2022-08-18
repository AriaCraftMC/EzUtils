<h1 align="center">EzUtils</h1>

# EzUtils

EzUtils 是一个简单易用的插件，它让服务器管理员可以从游戏内或控制台管理插件，而无需重新启动服务器。

## 特征
* 从游戏内或控制台启用、禁用、重启、加载、重新加载和卸载插件。
* 按字母顺序列出插件，如果指定则带有版本。
* 获取有关插件的有用信息，例如命令、版本、作者等。
* 轻松管理插件，无需不断重启服务器。
* 列出插件已注册的命令。
* 查找命令注册到的插件。
*命令名称和插件名称的选项卡完成。
* 将带有版本的插件列表转储到文件中。
* 使用 dev.bukkit.org 检查插件是否是最新的
* 权限支持 - 所有命令默认为 OP。

## 命令
|命令 |说明 |
| --------------- | ---------------- |
| /ezutils 帮助 |显示帮助信息。 |
| /ezutils 列表 [-v] |按字母顺序列出插件。使用“-v”来包含版本。 |
| /ezutils 信息 [插件] |显示有关插件的信息。 |
| /ezutils 转储 |将插件名称和版本转储到文件中。 |
| /ezutils 用法 [插件] |列出插件已注册的命令。 |
| /ezutils 查找 [命令] |查找命令注册到的插件。 |
| /ezutils 启用 [插件&#124;all] |启用插件。 |
| /ezutils 禁用 [插件&#124;all] |禁用插件。 |
| /ezutils restart [插件&#124;all] |重新启动（禁用/启用）插件。 |
| /ezutils 加载 [插件] |加载插件。 |
| /ezutils 重新加载 [插件&#124;全部] |重新加载（卸载/加载）插件。 |
| /ezutils 卸载 [插件] |卸载插件。 |
| /ezutils 检查 [插件&#124;all] [-f] |检查插件是否是最新的。 |
| /ezutils 崩溃 [播放器] [-f] |使玩家客户端崩溃。 |
| /ezutils 服务器广播 [消息] [-f] |服务器演员。 |

## 权限
|权限节点 |默认 |说明 |
| ------------------------- | ---------- | ---------------- |
| ezutils.admin |操作 |允许使用所有 EzUtils 命令。 |
| ezutils.update |操作 |允许用户查看更新消息。 |
| ezutils.help |操作 |允许使用帮助命令。 |
| ezutils.list |操作 |允许使用 list 命令。 |
| ezutils.info |操作 |允许使用 info 命令。 |
| ezutils.dump |操作 |允许使用转储命令。 |
| ezutils.usage |操作 |允许使用使用命令。 |
| ezutils.lookup |操作 |允许使用查找命令。 |
| ezutils.enable |操作 |允许使用 enable 命令。 |
| ezutils.enable.all |操作 |允许使用 enable all 命令。 |
| ezutils.disable |操作 |允许使用禁用命令。 |
| ezutils.disable.all |操作 |允许使用 disable all 命令。 |
| ezutils.restart |操作 |允许使用重新启动命令。 |
| ezutils.restart.all |操作 |允许使用restart all 命令。 |
| ezutils.load |操作 |允许使用加载命令。 |
| ezutils.reload |操作 |允许使用重新加载命令。 |
| ezutils.reload.all |操作 |允许使用 reload all 命令。 |
| ezutils.unload |操作 |允许使用卸载命令。 |
| ezutils.check |操作 |允许使用检查命令。 |
| ezutils.crash |操作 |允许使用 crash 命令。 |
| ezutils.servercast |操作 |允许使用 servercast 命令。 |
| ezutils.check.all |操作 |允许使用检查命令。 |

## 配置
|档案 |网址 |
| ----- | ------- |
| config.yml | https://github.com/NuymakStone/EzUtils/blob/master/src/main/resources/config.yml |

## 赞助商

<div style="text-align:center" markdown="1">

![image](https://raw.githubusercontent.com/NuymakStone/EzUtils/master/images/jetbrains_logo.png "JetBrains")

JetBrains 善意地支持 EzUtils 开源项目及其全功能 Java IDE。

在 <a href="http://www.jetbrains.com/">他们的网站上查看 JetBrain 的领先软件产品。</a>

---

