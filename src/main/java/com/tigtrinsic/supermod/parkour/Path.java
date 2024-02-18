package com.tigtrinsic.supermod.parkour;

import org.bukkit.util.Vector;

public class Path {
    private Vector startPoint;
    private Vector endPoint;

    public Path(Vector startPoint, Vector endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Vector traverseDistance(Vector startPoint, double distance) {
        Vector direction = endPoint.clone().subtract(startPoint).normalize();
        Vector newStartPoint = startPoint.clone().add(direction.multiply(distance));
        return newStartPoint;
    }
    public Vector getStartPoint() {
        return startPoint;
    }

    public Vector getEndPoint() {
        return endPoint;
    }
}



//Your mom is a hoe