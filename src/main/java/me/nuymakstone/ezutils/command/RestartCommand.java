package me.nuymakstone.ezutils.command;

/*
 * #%L
 * EzUtils
 * %%
 * Copyright (C) 2010 - 2014 EzUtils
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import me.nuymakstone.ezutils.EzUtils;
import me.nuymakstone.ezutils.util.PluginUtil;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

/**
 * Command that restarts plugin(s).
 *
 * @author nuymakstone
 */
public class RestartCommand extends AbstractCommand {

    /**
     * The name of the command.
     */
    public static final String NAME = "Restart";

    /**
     * The description of the command.
     */
    public static final String DESCRIPTION = "Restart a plugin.";

    /**
     * The main permission of the command.
     */
    public static final String PERMISSION = "ezutils.restart";

    /**
     * The proper usage of the command.
     */
    public static final String USAGE = "/ezutils restart <plugin|all>";

    /**
     * The sub permissions of the command.
     */
    public static final String[] SUB_PERMISSIONS = {"all"};

    /**
     * Construct out object.
     *
     * @param sender the command sender
     */
    public RestartCommand(CommandSender sender) {
        super(sender, NAME, DESCRIPTION, PERMISSION, SUB_PERMISSIONS, USAGE);
    }

    /**
     * Execute the command.
     *  @param sender  the sender of the command
     * @param command the command being done
     * @param label   the name of the command
     * @param args    the arguments supplied
     * @return
     */
    @Override
    public boolean execute(CommandSender sender, Command command, String label, String[] args) {

        if (!hasPermission()) {
            sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("error.no-permission"));
            return false;
        }

        if (args.length < 2) {
            sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("error.specify-plugin"));
            sendUsage();
            return false;
        }

        if (args[1].equalsIgnoreCase("all") || args[1].equalsIgnoreCase("*")) {
            if (hasPermission("all")) {
                PluginUtil.disableAll();
                PluginUtil.enableAll();
                sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("restart.all"));
            } else {
                sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("error.no-permission"));
            }
            return false;
        }

        Plugin target = PluginUtil.getPluginByName(args, 1);

        if (target == null) {
            sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("error.invalid-plugin"));
            sendUsage();
            return false;
        }

        if (PluginUtil.isIgnored(target)) {
            sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("error.ignored"));
            return false;
        }

        PluginUtil.disable(target);
        PluginUtil.enable(target);

        sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("restart.restarted", target.getName()));

        return false;
    }
}
