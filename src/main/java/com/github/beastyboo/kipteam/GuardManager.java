package com.github.beastyboo.kipteam;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class GuardManager {

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

        zombie.setAdult();

        guards.add(zombie.getUniqueId());
        return zombie;
    }
}
