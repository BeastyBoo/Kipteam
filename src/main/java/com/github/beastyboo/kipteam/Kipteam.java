package com.github.beastyboo.kipteam;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public final class Kipteam extends JavaPlugin {

    private final GuardManager guardManager = new GuardManager();

    @Override
    public void onEnable() {
        this.getCommand("guard").setExecutor(new GuardSpawnCommand(this));


        Listener[] listeners = new Listener[] {
          new HitDetectionListener(this), new DeathDetectionListener(this)
        };

        registerListeners(Arrays.asList(listeners));
    }

    @Override
    public void onDisable() {
    }

    public GuardManager getGuardManager() {
        return guardManager;
    }

    private void registerListeners(List<Listener> listeners) {
        listeners.forEach(listener -> {
            this.getServer().getPluginManager().registerEvents(listener, this);
        });
    }

}
