package com.github.beastyboo.kipteam;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DeathDetectionListener implements Listener {

    private final Kipteam kipteam;

    public DeathDetectionListener(Kipteam kipteam) {
        this.kipteam = kipteam;
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        kipteam.getGuardManager().removeIfPresent(event.getEntity().getUniqueId());
    }
}
