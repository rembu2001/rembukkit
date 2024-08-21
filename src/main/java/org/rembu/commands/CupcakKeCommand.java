package org.rembu.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.checkerframework.checker.nullness.qual.NonNull;

public class CupcakKeCommand implements CommandExecutor {

    private final String TEXT = "[REDACTED FOR THE PURPOSES OF PROFFESIONALISM]";

    public CupcakKeCommand (@NonNull FileConfiguration config) {
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(TEXT);
        return false;
    }
}
