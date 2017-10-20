package test.java;

import main.java.Calculator;

import static org.junit.Assert.*;

public class CalculatorTest {
    @org.junit.Test
    public void TestAddition() throws Exception {
        Calculator testAddition = new Calculator();
        double expected = 34d;
        double actual = testAddition.Calculate("11+23");
        assertEquals("Test", expected, actual, 0.001);
    }
    @org.junit.Test
    public void TestSubtraction() throws Exception{
        Calculator testSubtraction = new Calculator();
        double expected = 10d;
        double actual=testSubtraction.Calculate("23-13");
        assertEquals("Test", expected, actual, 0.001);
    }
    @org.junit.Test
    public void TestSegmentation() throws Exception{
        Calculator testSegmentation = new Calculator();
        double expected = 9d;
        double actual=testSegmentation.Calculate("45/5");
        assertEquals("Test", expected, actual, 0.001);
    }
    @org.junit.Test
    public void TestMultiplication() throws Exception{
        Calculator testMultiplication = new Calculator();
        double expected = 225d;
        double actual=testMultiplication.Calculate("45*5");
        assertEquals("Test", expected, actual, 0.001);
    }
    @org.junit.Test
    public void TestBrackets() throws Exception{
        Calculator testBrackets = new Calculator();
        double expected = 25d;
        double actual=testBrackets.Calculate("(45*5)-(100*2)");
        assertEquals("Test", expected, actual, 0.001);
    }
}
