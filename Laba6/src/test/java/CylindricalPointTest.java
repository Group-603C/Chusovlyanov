package test.java;

import main.java.CylindricalPoint;
import org.junit.Test;

import static org.junit.Assert.*;

public class CylindricalPointTest {
    @Test
    public void getRho() throws Exception {
        CylindricalPoint point = new CylindricalPoint(1d, 2d, 3d);
        double actual = point.getRho();
        double expected = 1;
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void getPhi() throws Exception {
        CylindricalPoint point = new CylindricalPoint(1d, 2d, 3d);
        double actual = point.getPhi();
        double expected = 2;
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void getZ() throws Exception {
        CylindricalPoint point = new CylindricalPoint(1d, 2d, 3d);
        double actual = point.getZ();
        double expected = 3;
        assertEquals(expected, actual,0.0001);

}

    @Test
    public void toCaresian() throws Exception {
        CylindricalPoint point = new CylindricalPoint(1d,2d,3d);
        point.toCaresian();
        double actualRho =point.getRho();
        double actualPhi =point.getPhi();
        double actualZ =point.getZ();
        double expectedRho =2.23606;
        double expectedPhi =1.10714;
        double expectedZ = 3.0;
        assertEquals(expectedRho,actualRho,0.0001);
        assertEquals(expectedPhi,actualPhi,0.0001);
        assertEquals(expectedZ,actualZ,0.0001);
    }

}