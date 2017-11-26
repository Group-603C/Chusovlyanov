package main.java;

import static main.java.Point.isOnePlane;

public class Main {
    public static void main(String[] args) {
        Point b = new Point(3,7,5);
        Point c = new Point(7,7,7);
        Point f = new Point(5,5,5);
        Point d = new Point(5,5,6);
        System.out.println(isOnePlane(b,c,f,d));
    }
}
