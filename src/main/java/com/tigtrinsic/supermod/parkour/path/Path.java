package com.tigtrinsic.supermod.parkour.path;

import org.bukkit.util.Vector;

public interface Path {
    Vector traverseDistance(Vector startPoint, double distance);
    Vector getStartPoint();
}