package com.github.beastyboo.kipteam;

import org.bukkit.plugin.java.JavaPlugin;

public final class Kipteam extends JavaPlugin {

    private final GuardManager guardManager = new GuardManager();

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("guard").setExecutor(new GuardSpawnCommand(this));
        this.getServer().getPluginManager().registerEvents(new HitDetectionListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public GuardManager getGuardManager() {
        return guardManager;
    }
}
