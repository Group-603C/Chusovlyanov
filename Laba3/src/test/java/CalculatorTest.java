package test.java;

import main.java.Calculator;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class CalculatorTest {
    @org.junit.Test
    public void TestAddition() throws Exception {

        double actual = Calculator.Calculate("11+23");
        assertEquals("Addition check", 34d, actual, 0.001);
    }

    @org.junit.Test
    public void TestStringNull() throws Exception {

        double actual = Calculator.Calculate("");
        assertEquals( 0, actual, 0.001);
    }

    @Test(expected = EmptyStackException.class)
    public void Test() throws Exception {
        double actual = Calculator.Calculate("((");
    }



    @org.junit.Test
    public void TestSubtraction() throws Exception {

        double actual = Calculator.Calculate("23-13");
        assertEquals("Check for subtraction", 10d, actual, 0.001);
    }

    @org.junit.Test
    public void TestSegmentation() throws Exception {

        double actual = Calculator.Calculate("45/5");

        assertEquals("Fission check", 9d, actual, 0.001);
    }

    @org.junit.Test
    public void TestMultiplication() throws Exception {

        double actual = Calculator.Calculate("45*5");
        assertEquals("Multiplication check", 225d, actual, 0.001);
    }

    @org.junit.Test
    public void TestBrackets() throws Exception {

        double actual = Calculator.Calculate("(45+1)*(102-2)");
        assertEquals("Checking parentheses", 4600d, actual, 0.001);
    }

    @org.junit.Test
    public void TestNull() throws Exception {

        double actual = Calculator.Calculate(null);
        assertEquals("Return null", 0, actual, 0.001);
    }

}

