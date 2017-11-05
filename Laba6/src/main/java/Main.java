package main.java;

import static main.java.Point.isOneStraightLine;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(1, 2, -1);
        Point b = new Point(0, 1, 5);
        Point c = new Point(-1, 2, 1);
        Point d = new Point(2, 1, 3);
        System.out.println(d.isOnePlane(a, b, c, d));
    }
}
