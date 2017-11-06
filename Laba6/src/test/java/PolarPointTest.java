package test.java;

import main.java.Point;
import main.java.PolarPoint;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolarPointTest {
    @Test
    public void getRho() throws Exception {
        PolarPoint point = new PolarPoint(2.23606,1.10714);
        Point actual = point.toCartesian();
        double actualX = actual.getX();
        double expectedX =1;
        assertEquals(expectedX,actualX,0.0001);
    }

    @Test
    public void getPhi() throws Exception {
        PolarPoint point = new PolarPoint(2.23606,1.10714);
        Point actual = point.toCartesian();
        double actualY = actual.getY();
        double expectedY =2;
        assertEquals(expectedY,actualY,0.0001);
    }

    @Test
    public void toCartesian() throws Exception {
        PolarPoint point = new PolarPoint(2.23606,1.10714);
        Point actual = point.toCartesian();
        double actualX =actual.getX();
        double actualY =actual.getY();
        double expectedX =1;
        double expectedY =2;
        assertEquals(expectedX,actualX,0.0001);
        assertEquals(expectedY,actualY,0.0001);
    }

}