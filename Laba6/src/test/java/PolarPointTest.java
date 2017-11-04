package test.java;

import main.java.PolarPoint;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolarPointTest {
    @Test
    public void getRho() throws Exception {
        PolarPoint point = new PolarPoint(1,2);
        double actual = point.getRho();
        double expected =1;
        assertEquals(expected,actual,0.0001);
    }

    @Test
    public void getPhi() throws Exception {
        PolarPoint point = new PolarPoint(1,2);
        double actual = point.getPhi();
        double expected =2;
        assertEquals(expected,actual,0.0001);
    }

    @Test
    public void toCartesian() throws Exception {
        PolarPoint point = new PolarPoint(1,2);
        point.toCartesian();
        double actualRho =point.getRho();
        double actualPhi =point.getPhi();
        double expectedRho =2.23606;
        double expectedPhi =1.10714;
        assertEquals(expectedRho,actualRho,0.0001);
        assertEquals(expectedPhi,actualPhi,0.0001);
    }

}