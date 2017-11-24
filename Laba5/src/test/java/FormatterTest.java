package test.java;

import main.java.Formatter;
import static org.junit.Assert.*;

public class FormatterTest {
    @org.junit.Test
    public void numericTest() throws Exception {
        String actual = Formatter.build("There must be a number {0}",40);
        String expected ="There must be a number 40";
        assertEquals("Test int ",expected,actual);

        actual = Formatter.build("There must be a number {0}", 40d);
        expected ="There must be a number 40.0";
        assertEquals("Test double ",expected,actual);

        actual = Formatter.build("There must be a number {0}",40f);
        expected ="There must be a number 40.0";
        assertEquals("Test float ",expected,actual);

        actual = Formatter.build("There must be a number {0}",false);
        expected ="There must be a number false";
        assertEquals("Test boolean ",expected,actual);
    }

    @org.junit.Test
    public void characterTest() throws Exception {
        String actual = Formatter.build("There must be symbols {0}","String");
        String expected ="There must be symbols String";
        assertEquals("Test String ",expected,actual);

        actual = Formatter.build("There must be symbols {0}",'C');
        expected ="There must be symbols C";
        assertEquals("Test char ",expected,actual);
    }

    @org.junit.Test
    public void variousTests() throws Exception {
        String actual = Formatter.build("There must be number {1} and symbols {0}", "String", 20);
        String expected = "There must be number 20 and symbols String";
        assertEquals("Reverse order ", expected, actual);

        actual = Formatter.build("", "String", 20);
        expected = null;
        assertEquals("Empty line ", expected, actual);

        actual = Formatter.build("There must be number and symbols");
        expected = "There must be number and symbols";
        assertEquals("Without arguments", expected, actual);
    }
}
