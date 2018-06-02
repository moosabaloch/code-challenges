package com.code.challenges.averagedistance;

/**
 * Implement a function to calculate the average distance between three points in a single plane where the coordinates of these points are (x1,y1), (x2,y2) and (x3,y3)
 *
 * @author Luiz Azevedo
 * @version 1.0 31/05/18
 */
public class Point {

    private final int x, y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public double averageDistance(final Point a, final Point b, final Point c) {
        return (distance(a, b) + distance(b, c) + distance(a, c)) / 3;
    }

    public double distance(final Point a, final Point b) {
        return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
    }
}
