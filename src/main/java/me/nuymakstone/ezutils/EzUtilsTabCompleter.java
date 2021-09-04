package me.nuymakstone.ezutils;

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

import me.nuymakstone.ezutils.util.PluginUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

/**
 * Completes partial matches in command and plugin names.
 *
 * @author nuymakstone
 */
public class EzUtilsTabCompleter implements TabCompleter {

    /**
     * Valid command names.
     */
    private static final String[] COMMANDS = {"check", "disable", "dump", "enable", "help", "info", "list", "load", "lookup", "reload", "restart", "unload", "usage", "servercast","crash"};

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if (sender.isOp() || sender.hasPermission("ezutils.admin") || sender.hasPermission("ezutils." + args[0])) {

            List<String> completions = new ArrayList<>();
            if (args.length == 1) {
                String partialCommand = args[0];
                List<String> commands = new ArrayList<>(Arrays.asList(COMMANDS));
                StringUtil.copyPartialMatches(partialCommand, commands, completions);
            }
            if (args.length == 2) {
                String partialPlugin = args[1];
                List<String> plugins = PluginUtil.getPluginNames(false);
                StringUtil.copyPartialMatches(partialPlugin, plugins, completions);
                for (Player p : Bukkit.getOnlinePlayers()) {
                    String namelist = p.getName();
                    List<String> name = new ArrayList<>(Arrays.asList(namelist));
                    StringUtil.copyPartialMatches(partialPlugin,name, completions);
                    }
            }
            Collections.sort(completions);
            return completions;
        }

        return null;

    }

}
