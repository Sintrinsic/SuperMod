package com.tigtrinsic.supermod;

import org.bukkit.plugin.java.JavaPlugin;

public class SuperMod extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("YourPlugin has been enabled!");

        // Create an instance of ParkourGame
        ParkourGame parkourGame = new ParkourGame(getServer().getWorlds().getFirst()); // Change this to the world you want

        // Create a line of blocks
        parkourGame.createLineOfBlocks(0, 64, 0, 1000); // Change these values as needed

        // Register the event listener
        getServer().getPluginManager().registerEvents(new PlayerClickListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("YourPlugin has been disabled.");

        // Any cleanup code when the plugin is disabled or server is stopping
    }

    // You can add more methods here, such as command executors, event listeners, etc.
}
