package test.com.company;

import com.company.IExpression;
import com.company.Binary.*;
import com.company.Tools.*;
import com.company.Unary.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionTests {

    private final double eps = 0.0000001;

    private IExpression expression;

    @BeforeEach
    public void beforeEach() {
        expression = null;
    }

    @Test
    public void addition() {

        //Single
        expression = new Addition("123.123");
        assertEquals(123.123, expression.calculate(), eps);

        //Pair
        expression = new Addition("123.123", 1.4);
        assertEquals(124.523, expression.calculate(), eps);

        //Multi
        expression = new Addition("123.123", 1.2, "1.1", 42, "0");
        assertEquals(167.423, expression.calculate(), eps);
    }

    @Test
    public void division() {

        expression = new Division("25.5",5);
        assertEquals(5.1, expression.calculate(), eps);

        expression = new Division("-12.0", 4);
        assertEquals(-3.0, expression.calculate(), eps);

        expression = new Division("42.4", 0);
        assertTrue(Double.isNaN(expression.calculate()));
    }

    @Test
    public void multiplication() {

        //Single
        expression = new Multiplication("1.2");
        assertEquals(1.2, expression.calculate(), eps);

        //Pair
        expression = new Multiplication("1.2", 1.3);
        assertEquals(1.56, expression.calculate(), eps);

        //Multi
        expression = new Multiplication("1.2", 1.2, "1");
        assertEquals(1.44, expression.calculate(), eps);
    }

    @Test
    public void power() {

        //Normal
        expression = new Power("4.1", 2);
        assertEquals(16.81, expression.calculate(), eps);

        //Root
        expression = new Power(16.81, 1.0 / 2);
        assertEquals(4.1, expression.calculate(), eps);

        //Root with minus
        expression = new Power(-27, 1.0 / 3);
        assertEquals(-3, expression.calculate(), eps);


        //Root with minus
        expression = new Power(-8, 5.0 / 3);
        assertEquals(-32, expression.calculate(), eps);

        //Nan
        expression = new Power(-16.81, 1.0 / 2);
        assertTrue(Double.isNaN(expression.calculate()));
    }
    @Test
    public void rest() {

        expression = new Rest("7.0", 2);
        assertEquals(1.0, expression.calculate(), eps);

        expression = new Rest("-14.0", 3);
        assertEquals(1.0, expression.calculate(), eps);

        expression = new Rest("14.0", -3);
        assertEquals(2.0, expression.calculate(), eps);

        expression = new Rest("4.2", 0);
        assertTrue(Double.isNaN(expression.calculate()));
    }

    @Test
    public void subtraction() {

        expression = new Subtraction("1.2", 10.1);
        assertEquals(-8.9, expression.calculate(), eps);
    }

    @Test
    public void negative() {

        //Positive
        expression = new Negative("1.2");
        assertEquals(-1.2, expression.calculate(), eps);

        //Negative
        expression = new Negative(-10.1);
        assertEquals(10.1, expression.calculate(), eps);
    }
    @Test
    public void absolute() {
        expression = new Absolute("105.0");
        assertEquals(105.0, expression.calculate(), eps);

        expression = new Absolute("-105.0");
        assertEquals(105.0, expression.calculate(), eps);
    }
    @Test
    public void square() {

        expression = new Square("12.0");
        assertEquals(144.0, expression.calculate(), eps);

        expression = new Square("-8.0");
        assertEquals(64.0, expression.calculate(), eps);
    }

    @Test
    public void value() {

        //null
        try {
            expression = new Value(null);
            fail("Process null reference");
        } catch (NullPointerException exception) {
        }

        //Custom object
        try {
            expression = new Value(new Object());
            fail("Process custom object");
        } catch (NumberFormatException exception) {
        }

        //Bad string
        try {
            expression = new Value(new Object());
            fail("Fuck");
        } catch (NumberFormatException exception) {
        }

        //Boolean
        try {
            expression = new Value(false);
            fail("Fuck");
        } catch (NumberFormatException exception) {
        }

        //Char
        try {
            expression = new Value('f');
            fail("Fuck");
        } catch (NumberFormatException exception) {
        }

        check(42, new Value(new TestExpression()));
        check(42, new Value("42"));
        check(42.2, new Value("42.2"));
        check(42, new Value((byte) 42));
        check(42, new Value((short) 42));
        check(42, new Value(42));
        check(42, new Value((long) 42));
        check(42.2, new Value((float) 42.2));
        check(42.2, new Value((double) 42.2));
    }
    private void check(double value, IExpression expression) {
        assertEquals(value, expression.calculate(), eps);
    }

    @Test
    public void cacheValue() {

        TestExpression tester = new TestExpression();

        //Single
        expression = new CacheValue(tester);
        assertEquals(0, tester.callCounter);

        assertEquals(42,expression.calculate(), eps);
        assertEquals(42,expression.calculate(), eps);
        assertEquals(42,expression.calculate(), eps);
        assertEquals(1, tester.callCounter);


        expression = new CacheValue(tester);
        assertEquals(1, tester.callCounter);

        assertEquals(42,expression.calculate(), eps);
        assertEquals(42,expression.calculate(), eps);
        assertEquals(42,expression.calculate(), eps);
        assertEquals(1, tester.callCounter);
    }

    private  class TestExpression implements IExpression {

        public int callCounter;

        public TestExpression(){
            callCounter = 0;
        }

        @Override
        public double calculate() {

            callCounter++;

            return 42;
        }
    }
}
