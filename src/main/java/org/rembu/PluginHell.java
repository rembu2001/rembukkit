package org.rembu;

import org.bukkit.plugin.java.JavaPlugin;
import org.rembu.commands.CupcakKeCommand;
import org.rembu.commands.JiafeiCommand;
import org.rembu.commands.ItemOrbitCommand;

public class PluginHell extends JavaPlugin {

    public void onEnable() {
        this.getCommand("cupcakke").setExecutor(new CupcakKeCommand(this.getConfig()));
        this.getCommand("jiafei").setExecutor(new JiafeiCommand(this.getConfig()));
        this.getCommand("item_orbit").setExecutor(new ItemOrbitCommand(this));
    }
}
