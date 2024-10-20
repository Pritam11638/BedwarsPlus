package com.github.pritam11638.bedwarsPlus;

import com.github.pritam11638.bedwarsPlus.Commands.BedwarsPlus.BedwarsPlusCommand;
import com.github.pritam11638.bedwarsPlus.Players.ProfileManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class BedwarsPlus extends JavaPlugin {
    public static BedwarsPlus plugin;
    public static ProfileManager profileManager;

    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;

        getLogger().fine("BedwarsPlus is starting up...");
        profileManager = new ProfileManager();

        Objects.requireNonNull(getCommand("bedwarsplus")).setExecutor(new BedwarsPlusCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
