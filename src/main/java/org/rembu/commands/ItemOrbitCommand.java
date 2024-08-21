package org.rembu.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

// needed for displaying sword items
import org.bukkit.entity.ItemDisplay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;
import org.rembu.PluginHell;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class ItemOrbitCommand implements CommandExecutor, Listener {

    // wanted three iron sword ItemDisplays to spawn
    Map<UUID, ItemDisplay[]> orbitingItems = new HashMap<>();

    /* public BukkitRunnable timer = new BukkitRunnable() {
        public void run() {
            rotateAboutXAxis(, 2D);
            rotateAboutYAxis(,10D);
            rotateAboutZAxis(, 4D);
        }
    }; */

    // @EventHandler

    public ItemOrbitCommand(@NonNull PluginHell plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public void tick() {
        // not sure what to put here either, god pls help me lol
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("you ain't a player!");
            sender.sendMessage("only players may use this command.");
            return true;
        }
        final ItemDisplay[] items = new ItemDisplay[3];
        final Location playerLocation = player.getLocation();

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            items[i] = playerLocation.getWorld().spawn(playerLocation.clone(), ItemDisplay.class, (spawnedDisplay) -> {
                final Vector3f    translation   = new Vector3f(1F, 0F, 0F);
                final AxisAngle4f leftRotation  = new AxisAngle4f();
                final Vector3f    scale         = new Vector3f(1F, 1F, 1F);
                final AxisAngle4f rightRotation = new AxisAngle4f();

                final Transformation xform = new Transformation(translation, leftRotation, scale, rightRotation);

                spawnedDisplay.setItemStack(new ItemStack(Material.IRON_SWORD));
                spawnedDisplay.setTransformation(xform);
                spawnedDisplay.setRotation(-180f + finalI * 120f,0);
                sender.sendMessage("Spawned a new sword.");
            });
            orbitingItems.put(player.getUniqueId(), items);
        }

        return true;
    }

    // putting these here for now
    private Vector rotateAboutXAxis(Vector v, double angle) {
        angle = Math.toRadians(angle);
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double y = v.getY() * cos - v.getZ() * sin;
        double z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }

    private Vector rotateAboutYAxis(Vector v, double angle) {
        angle = Math.toRadians(angle * -1);
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double x = v.getX() * cos + v.getZ() * sin;
        double z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }

    private Vector rotateAboutZAxis(Vector v, double angle) {
        angle = Math.toRadians(angle);
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double x = v.getX() * cos - v.getY() * sin;
        double y = v.getX() * sin + v.getY() * cos;
        return v.setX(x).setY(y);
    }
}
