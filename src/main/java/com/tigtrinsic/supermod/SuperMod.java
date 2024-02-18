package com.tigtrinsic.supermod;

import com.tigtrinsic.supermod.parkour.Course;
import com.tigtrinsic.supermod.parkour.Path;
import org.bukkit.util.Vector;
import org.bukkit.plugin.java.JavaPlugin;

public class SuperMod extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("YourPlugin has been enabled!");

        // Create an instance of Path
        Vector startPoint = new Vector(0, 64, 0); // Change these values as needed
        Vector endPoint = new Vector(1000, 1000, 1000); // Change these values as needed
        Path path = new Path(startPoint, endPoint);

        // Create an instance of Course
        Course course = new Course(path, getServer().getWorlds().getFirst()); // Change this to the world you want
        course.fillBlocks();

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