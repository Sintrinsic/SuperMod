package com.tigtrinsic.supermod.parkour;

import com.tigtrinsic.supermod.parkour.path.LinePath;
import com.tigtrinsic.supermod.parkour.path.Path;
import org.bukkit.World;
import org.bukkit.util.Vector;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Course {
    private Path path;
    private World world;

    public Course(Path path, World world) {
        // Path is the interface, but any class that implements Path can be used here
        this.path = path;
        this.world = world;
    }

    public void fillBlocks() {
        Vector currentPoint = path.getStartPoint();
        Vector newPoint;
        while ((newPoint = path.traverseDistance(currentPoint, 1)) != null) {
            Block block = world.getBlockAt(newPoint.getBlockX(), newPoint.getBlockY(), newPoint.getBlockZ());
            block.setType(Material.STONE);
            currentPoint = newPoint;
        }
    }
}