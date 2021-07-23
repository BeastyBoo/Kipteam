package com.github.beastyboo.kipteam;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HitDetectionListener implements Listener {

    private final Kipteam kipteam;

    public HitDetectionListener(Kipteam kipteam) {
        this.kipteam = kipteam;
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            if(kipteam.getGuardManager().isGuard(event.getDamager().getUniqueId())) {
                player.sendMessage(Component.text("You were hit by a guard!"));
            }
        }
    }

}
