package org.rembu.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.checkerframework.checker.nullness.qual.NonNull;

public class JiafeiCommand implements CommandExecutor {

    private final String TEXT = "AAAAAAAAAAAH Měi cì dōu xiǎng zhuāng zuò hěn juè jiàng, Dàn shì jiàn miàn zì jǐ què jiǎo xiè tóu xiàng";

    public JiafeiCommand (@NonNull FileConfiguration config) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(TEXT);
        return false;
    }
}
