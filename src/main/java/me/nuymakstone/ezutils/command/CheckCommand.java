package me.nuymakstone.ezutils.command;

/*
 * #%L
 * EzUtils
 * %%
 * Copyright (C) 2010 - 2015 EzUtils
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
import me.nuymakstone.ezutils.util.SpiGetUtil;
import me.nuymakstone.ezutils.util.FlagUtil;
import me.nuymakstone.ezutils.util.StringUtil;
import me.nuymakstone.ezutils.util.ThreadUtil;
import me.nuymakstone.ezutils.result.UpdateResult;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * Command that checks if a plugin is up-to-date.
 *
 * @author nuymakstone
 */
public class CheckCommand extends AbstractCommand {

    /**
     * The name of the command.
     */
    public static final String NAME = "Check";

    /**
     * The description of the command.
     */
    public static final String DESCRIPTION = "Check if a plugin is up-to-date.";

    /**
     * The main permission of the command.
     */
    public static final String PERMISSION = "ezutils.check";

    /**
     * The proper usage of the command.
     */
    public static final String USAGE = "/ezutils check <plugin>";

    /**
     * The sub permissions of the command.
     */
    public static final String[] SUB_PERMISSIONS = {"all"};

    /**
     * Construct out object.
     *
     * @param sender the command sender
     */
    public CheckCommand(CommandSender sender) {
        super(sender, NAME, DESCRIPTION, PERMISSION, SUB_PERMISSIONS, USAGE);
    }

    /**
     * Execute the command
     *  @param sender  the sender of the command
     * @param command the command being done
     * @param label   the name of the command
     * @param args    the arguments supplied
     * @return
     */
    @Override
    public boolean execute(final CommandSender sender, final Command command, final String label, final String[] args) {

        if (!hasPermission()) {
            sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("error.no-permission"));
            return false;
        }

        if (args.length < 2) {
            sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("error.specify-plugin"));
            sendUsage();
            return false;
        }

        final boolean toFile = FlagUtil.hasFlag(args, 'f');

        if (args[1].equalsIgnoreCase("all") || args[1].equalsIgnoreCase("*")) {

            if (hasPermission("all")) {

                sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("check.header"));

                ThreadUtil.async(new Runnable() {

                    @Override
                    public void run() {

                        Map<String, UpdateResult> results = SpiGetUtil.checkUpToDate();

                        final StringBuilder upToDate = new StringBuilder(), outOfDate = new StringBuilder(), unknown = new StringBuilder();

                        for (Map.Entry<String, UpdateResult> entry : results.entrySet()) {

                            UpdateResult.ResultType result = entry.getValue().getType();

                            String currentVersion = Bukkit.getPluginManager().getPlugin(entry.getKey()).getDescription().getVersion();

                            if (result == UpdateResult.ResultType.UP_TO_DATE) {
                                upToDate.append(entry.getKey() + "(" + currentVersion + ") ");
                            } else if (result == UpdateResult.ResultType.INVALID_PLUGIN || result == UpdateResult.ResultType.NOT_INSTALLED) {
                                unknown.append(entry.getKey() + "(" + currentVersion + ") ");
                            } else {
                                outOfDate.append(entry.getKey() + "(" + currentVersion + " -> " + entry.getValue().getLatestVersion() + ") ");
                            }

                        }

                        if (toFile) {

                            File outFile = new File(EzUtils.getInstance().getDataFolder(), "updates.txt");

                            PrintWriter writer = null;

                            try {

                                writer = new PrintWriter(outFile);

                                writer.println("Up-to-date (Installed):");
                                writer.println(upToDate);

                                writer.println("Out-of-date (Installed -> Latest):");
                                writer.println(outOfDate);

                                writer.println("Unknown (Installed):");
                                writer.println(unknown);

                            } catch (IOException e) {

                            } finally {
                                if (writer != null) {
                                    writer.close();
                                }
                            }

                            sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("check.file-done", outFile.getPath()));

                        } else {

                            ThreadUtil.sync(new Runnable() {
                                @Override
                                public void run() {
                                    sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("check.up-to-date-player", upToDate.toString()));
                                    sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("check.out-of-date-player", outOfDate.toString()));
                                    sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("check.unknown-player", unknown.toString()));
                                }
                            });

                        }

                    }

                });


            } else {
                sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("error.no-permission"));
            }

            return toFile;

        }

        final String pluginName = StringUtil.consolidateStrings(args, 1).replaceAll(" ", "+").replace("-[a-zA-Z]", "");

        sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("check.header"));

        ThreadUtil.async(new Runnable() {

            @Override
            public void run() {

                final UpdateResult result = SpiGetUtil.checkUpToDate(pluginName);

                ThreadUtil.sync(new Runnable() {

                    @Override
                    public void run() {
                        switch (result.getType()) {
                            case NOT_INSTALLED:
                                sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("check.not-found", result.getLatestVersion()));
                                break;
                            case OUT_OF_DATE:
                                sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("check.out-of-date", result.getCurrentVersion(), result.getLatestVersion()));
                                break;
                            case UP_TO_DATE:
                                sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("check.up-to-date", result.getCurrentVersion()));
                                break;
                            default:
                                sender.sendMessage(EzUtils.getInstance().getMessageFormatter().format("check.not-found-spigot"));
                        }
                    }

                });

            }

        });

        return toFile;
    }

}