package com.github.beastyboo.kipteam;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class GuardManager {

    //In order to keep it protected
    GuardManager() {
    }

    private final Set<UUID> guards = new HashSet<>();

    public boolean isGuard(UUID uuid) {
        return guards.contains(uuid);
    }

    public void removeIfPresent(UUID uuid) {
        if(isGuard(uuid)) {
            guards.remove(uuid);
        }
    }

    public Zombie guardFactory(Location location) {
        Entity entity = location.getWorld().spawnEntity(location, EntityType.ZOMBIE);
        Zombie zombie = (Zombie) entity;

        addProperties(zombie);

        guards.add(zombie.getUniqueId());
        return zombie;
    }

    private void addProperties(Zombie zombie) {
        zombie.setAdult();

        zombie.setCustomName(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "20" + ChatColor.DARK_GRAY + "] " +
                ChatColor.WHITE + "Guard " + ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "2000" +
                ChatColor.DARK_GRAY + "/" + ChatColor.GREEN + "2000" + ChatColor.DARK_GRAY + "]");

        zombie.setCustomNameVisible(true);

        zombie.getEquipment().setItemInMainHand(new ItemStack(Material.ARROW));
        zombie.setSilent(true);
    }

}
