package com.tigtrinsic.supermod.parkour.path;

import org.bukkit.util.Vector;

public class HelixPath implements Path {
    private Vector startPoint;
    private Integer length;
    private double diameter;
    private double wavelength;
    private Vector endPoint;

    public HelixPath(Vector startPoint, Integer length, double diameter, double wavelength) {
        this.startPoint = startPoint;
        this.length = length;
        this.diameter = diameter;
        this.wavelength = wavelength;
        endPoint = getPointAtDistance((double) length);
    }

    public Vector traverseDistance(Vector inputPoint, double distance) {
        // divide distance by circomference of the helix
        distance = distance / (2 * Math.PI * diameter);
        // Get the height of both input and start point:
        double y = inputPoint.getY();
        double yStart = startPoint.getY();
        double distanceOfInput = startPoint.distance(inputPoint) ;
        System.out.println("Distance of input: " + distanceOfInput);
        distanceOfInput = y - yStart;
        System.out.println("new Distance of input: " + distanceOfInput);
        
        
        // If the DistanceOfStart is greater than the total line length, return null
        if (distanceOfInput > length) {
            return null;
        }
        double newDistance = distanceOfInput + distance;
        // If the newDistance is greater than the total line length, return the end point
        if (newDistance > length) {
            return endPoint;
        }

        // Create a point along the line using NewDistance
        Vector newPoint = getPointAtDistance(newDistance);

        // Calculate the helical offset,
        Vector helicalOffset = calculateHelicalOffset(newDistance);
        return newPoint.add(helicalOffset);


    }

    @Override
    public Vector getStartPoint() {
        return startPoint;
    }

    private Vector calculateHelicalOffset(double distance) {
        double radius = diameter / 2;

        double x = radius * Math.cos(distance );
        double y = wavelength * distance; // Add this line
        double z = radius * Math.sin(distance );
        return new Vector(x, 0, z);
    }

    private double getDistanceOfClosestPointOnLine(Vector samplePoint) {
        // This might be wrong? I'm not sure. Finds the closest point on the line from start to end to the sample point,
        // then returns the distance from the start point to that closest point.
        // This lets us convert the StartPoint given by the Course's iterations to the distance along the line.
        Vector vectorFromStartToSample = samplePoint.clone().subtract(startPoint);
        Vector vectorFromStartToEnd = endPoint.clone().subtract(startPoint);

        Vector crossProduct = vectorFromStartToSample.getCrossProduct(vectorFromStartToEnd);
        double numerator = crossProduct.length();
        double denominator = vectorFromStartToEnd.length();

        return numerator / denominator;
    }

    private Vector rotateAroundAxisY(Vector v, double angle) {
        double x, z, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        x = v.getX() * cos + v.getZ() * sin;
        z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }

    private Vector getPointAtDistance(Double distance){
        // Get the point at a distance from StartPoint along the line by adding the distance to the Y axis.
        return startPoint.clone().add(new Vector(0, distance, 0));
    }
}