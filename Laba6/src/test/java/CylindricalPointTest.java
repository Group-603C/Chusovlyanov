package test.java;

import main.java.CylindricalPoint;
import main.java.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class CylindricalPointTest {
    @Test
    public void getRho() throws Exception {
        CylindricalPoint point = new CylindricalPoint(2.23606,1.10714,3d);
        Point actual = point.toCartesian();
        double actualX = actual.getX();
        double expectedX = 1d;
        assertEquals(expectedX, actualX, 0.0001);
    }

    @Test
    public void getPhi() throws Exception {
        CylindricalPoint point = new CylindricalPoint(2.23606,1.10714,3d);
        Point actual = point.toCartesian();
        double actualY = actual.getY();
        double expectedY = 2d;
        assertEquals(expectedY, actualY, 0.0001);
    }

    @Test
    public void getZ() throws Exception {
        CylindricalPoint point = new CylindricalPoint(2.23606,1.10714,3d);
        Point actual = point.toCartesian();
        double actualZ = point.getZ();
        double expected = 3d;
        assertEquals(expected, actualZ,0.0001);

}

    @Test
    public void toCaresian() throws Exception {
        CylindricalPoint point = new CylindricalPoint(2.23606,1.10714,3d);
        Point actual =point.toCartesian();
        double actualRho =actual.getX();
        double actualPhi =actual.getY();
        double actualZ =actual.getZ();
        double expectedRho =1d;
        double expectedPhi =2d;
        double expectedZ = 3.0;
        assertEquals(expectedRho,actualRho,0.0001);
        assertEquals(expectedPhi,actualPhi,0.0001);
        assertEquals(expectedZ,actualZ,0.0001);
    }

}