package com.code.challenges.averagedistance;

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
