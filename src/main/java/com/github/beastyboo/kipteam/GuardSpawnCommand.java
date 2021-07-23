package com.github.beastyboo.kipteam;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GuardSpawnCommand implements CommandExecutor {

    private final Kipteam kipteam;

    public GuardSpawnCommand(Kipteam kipteam) {
        this.kipteam = kipteam;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("guard")) {

            if(!(sender instanceof Player)) {
                sender.sendMessage("Console can't provide a location");
                return true;
            }

            Player player = (Player) sender;

            kipteam.getGuardManager().guardFactory(player.getLocation());
            player.sendMessage(Component.text("Guard spawned and registered!"));
        }
        return false;
    }
}
