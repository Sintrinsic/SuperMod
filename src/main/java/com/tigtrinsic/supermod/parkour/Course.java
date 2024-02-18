package com.tigtrinsic.supermod.parkour;

import org.bukkit.World;
import org.bukkit.util.Vector;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Course {
    private Path path;
    private World world;

    public Course(Path path, World world) {
        this.path = path;
        this.world = world;
    }

    public void fillBlocks() {
        Vector startPoint = path.getStartPoint();
        Vector endPoint = path.getEndPoint();
        // create the unit vector that matches the direction of the line but with magnitude of 1
        Vector direction = endPoint.clone().subtract(startPoint).normalize();
        // how long the line is
        double distance = startPoint.distance(endPoint);

        for (int i = 0; i < distance; i=i+5) {
            Vector newPoint = startPoint.clone().add(direction.clone().multiply(i));
            Block block = world.getBlockAt(newPoint.getBlockX(), newPoint.getBlockY(), newPoint.getBlockZ());
            block.setType(Material.STONE); // Change this to the material you want
        }
    }
}