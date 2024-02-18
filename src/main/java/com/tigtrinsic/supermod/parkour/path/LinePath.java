package com.tigtrinsic.supermod.parkour.path;

import org.bukkit.util.Vector;

public class LinePath implements Path{
    private Vector startPoint;
    private Vector endPoint;

    public LinePath(Vector startPoint, Vector endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Vector traverseDistance(Vector startPoint, double distance) {
        Vector direction = endPoint.clone().subtract(startPoint).normalize();
        Vector newStartPoint = startPoint.clone().add(direction.multiply(distance));

        // If the start point is the end point, return null
        if (startPoint.equals(endPoint)) {
            return null;
        }

        // If the new start point is beyond the end point, return the end point
        if (newStartPoint.distance(startPoint) > endPoint.distance(startPoint)) {
            return endPoint;
        }



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