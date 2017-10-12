package test.java;

import main.java.Calculator;

import static org.junit.Assert.*;

public class CalculatorTest {
    @org.junit.Test
    public void calculate() throws Exception {
        Calculator test1 =new Calculator();
        double expected = 31d;
        double actual = test1.Calculate("5*3+2*(12-4)");
        assertEquals("Test",expected,actual,0.001);
    }

}