package com.tigtrinsic.supermod;

import org.bukkit.World;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class ParkourGame {
    private World world;
    private int score;

    public ParkourGame(World world) {
        this.world = world;
        this.score = 0;
    }

    public void createLineOfBlocks(int startX, int startY, int startZ, int length) {
        for (int i = 0; i < length; i++) {
            Block block = world.getBlockAt(startX , startY + i, startZ);
            block.setType(Material.STONE); // Change this to the material you want
        }
    }

    // Add more methods for game rules, player scores, etc.
}