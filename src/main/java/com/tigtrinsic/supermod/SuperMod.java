package com.tigtrinsic.supermod;

import com.tigtrinsic.supermod.parkour.Course;
import com.tigtrinsic.supermod.parkour.path.LinePath;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;
import org.bukkit.plugin.java.JavaPlugin;

public class SuperMod extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("YourPlugin has been enabled!");
        reset(500, 500, 64, 100);
        // Create an instance of Path
        Vector startPoint = new Vector(0, 62, 0); // Change these values as needed
        Vector endPoint = new Vector(1000, 1000, 1000); // Change these values as needed
        LinePath path = new LinePath(startPoint, endPoint);

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


    public void reset(int width, int length, int startY, int height) {
        int startX = (width/2)*-1, endX = width/2;
        int startZ = (length/2)*-1, endZ = length/2;

        System.out.println("In server. Starting clean small. ");
        for (int y = startY; y <= height; y++) {
            for (int x = startX; x <= endX; x++) {
                for (int z = startZ; z <= endZ; z++) {
                    Block block = getServer().getWorlds().getFirst().getBlockAt(x, y, z);
                    if(y == startY) {
                        block.setType(Material.GRASS_BLOCK);
                    } else {
                        block.setType(Material.AIR);
                    }

                }
            }
        }
        System.out.println("Clean done. Ready. ");

    }
}