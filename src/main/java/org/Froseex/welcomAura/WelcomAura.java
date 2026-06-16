package org.Froseex.welcomAura;

import org.bukkit.plugin.java.JavaPlugin;

public final class WelcomAura extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Плагин включен");
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new WelcomAuraEvent(this), this);
    }

    @Override
    public void onDisable() {
    }
}
