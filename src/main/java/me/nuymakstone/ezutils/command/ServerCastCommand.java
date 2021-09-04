package me.nuymakstone.ezutils.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ServerCastCommand extends AbstractCommand{

    /**
     * The name of the command.
     */
    public static final String NAME = "ServerCast";

    /**
     * The description of the command.
     */
    public static final String DESCRIPTION = "子服广播。";

    /**
     * The main permission of the command.
     */
    public static final String PERMISSION = "ezutils.servercast";

    /**
     * The proper usage of the command.
     */
    public static final String USAGE = "/ezutils servercast <message>";

    /**
     * The sub permissions of the command.
     */
    public static final String[] SUB_PERMISSIONS = {""};

    /**
     * Construct out object.
     *
     * @param sender the command sender
     */
    public ServerCastCommand(CommandSender sender) {
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
        String message = "";
        String cast = "";
        for(int i = 1; i < args.length; i++) {
            message = message + args[i] + " ";
        }
        cast = ChatColor.translateAlternateColorCodes('&',message);
        Bukkit.broadcastMessage(cast);
        return false;
    }
}
