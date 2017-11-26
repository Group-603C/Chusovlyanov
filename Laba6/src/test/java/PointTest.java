package test.java;

import main.java.CylindricalPoint;
import main.java.Point;
import main.java.PolarPoint;

import static org.junit.Assert.*;

public class PointTest {
    @org.junit.Test
    public void getX() throws Exception {
        Point point = new Point(1, 2);
        double actual = point.getX();
        double expected = 1;
        assertEquals(expected, actual, 0.0001);
    }

    @org.junit.Test
    public void getY() throws Exception {
        Point point = new Point(1, 2);
        double actual = point.getY();
        double expected = 2;
        assertEquals(expected, actual, 0.0001);
    }

    @org.junit.Test
    public void getZ() throws Exception {
        Point point = new Point(1, 2, 3);
        double actual = point.getZ();
        double expected = 3d;
        assertEquals(expected, actual, 0.0001);
    }

    @org.junit.Test
    public void distanceTo() throws Exception {
        Point one = new Point(1, 2);
        Point two = new Point(2, 3);
        double actual = one.distanceTo(two);
        double expected = 1.41421;
        assertEquals(expected, actual, 0.0001);

        one = new Point(1, 2, 3);
        two = new Point(2, 3, 4);
        actual = one.distanceTo(two);
        expected = 1.73205;
        assertEquals(expected, actual, 0.0001);
    }

    @org.junit.Test
    public void toPolar() throws Exception {
        Point point = new Point(3, 4);
        PolarPoint one = point.toPolar();
        double actualRho = one.getRho();
        double actualPhi = one.getPhi();
        double expectedRho = 5.0000;
        double expectedPhi = 0.927229;
        assertEquals(expectedRho, actualRho, 0.0001);
        assertEquals(expectedPhi, actualPhi, 0.0001);

    }

    @org.junit.Test
    public void toCylindrical() throws Exception {
        Point point = new Point(1, 2, 3);
        CylindricalPoint one = point.toCylindrical();
        double actualRho = one.getRho();
        double actualPhi = one.getPhi();
        double actualZ = one.getZ();
        double expectedRho = 2.23606;
        double expectedPhi = 1.10714;
        double expectedZ = 3.0;
        assertEquals(expectedRho, actualRho, 0.0001);
        assertEquals(expectedPhi, actualPhi, 0.0001);
        assertEquals(expectedZ, actualZ, 0.0001);
    }

    @org.junit.Test
    public void isOneStraightLine() throws Exception {
        Point one = new Point(5, 6);
        Point two = new Point(5, 2);
        Point three = new Point(5, 8);
        boolean actual = Point.isOneStraightLine(one, two, three);
        boolean expected = true;
        assertEquals(expected, actual);

        one = new Point(5, 6);
        two = new Point(6, 2);
        three = new Point(5, 8);
        actual = Point.isOneStraightLine(one, two, three);
        expected = false;
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void isOnePlane() throws Exception {
        Point a = new Point(1, 2, -1);
        Point b = new Point(0, 1, 5);
        Point c = new Point(-1, 2, 1);
        Point d = new Point(2, 1, 3);
        boolean actual = Point.isOnePlane(a, b, c, d);
        boolean expected = true;
        assertEquals(expected, actual);

        a = new Point(1, 2, -1);
        b = new Point(2, 1, 5);
        c = new Point(-1, 0, 1);
        d = new Point(4, 1, 3);
        actual = Point.isOnePlane(a, b, c, d);
        expected = false;
        assertEquals(expected, actual);
    }

}
