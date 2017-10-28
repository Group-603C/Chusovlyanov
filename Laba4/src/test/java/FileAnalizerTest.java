package test.java;

import main.java.FileAnalizer;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FileAnalizerTest {
    @org.junit.Test
    public void countLetters() throws Exception {
        FileAnalizer test = new FileAnalizer("test.txt");
        int actual =test.countLetters();
        assertEquals("Check the number of letters", 42, actual,0.1);
    }

    @Test(expected = FileNotFoundException.class)
    public void counts() throws Exception {
        FileAnalizer test = new FileAnalizer("1.txt");
    }

    @org.junit.Test
    public void countWords() throws Exception {
        FileAnalizer test = new FileAnalizer("test.txt");
        int actual =test.countWords();
        assertEquals("Check the number of words",9, actual,0.1);
    }

    @org.junit.Test
    public void countLines() throws Exception {
        FileAnalizer test = new FileAnalizer("test.txt");
        int actual =test.countLines();
        assertEquals("Checking the number of rows",3, actual,0.1);
    }

    @org.junit.Test
    public void countFrequencyCharacteristic() throws Exception {
        FileAnalizer test = new FileAnalizer("test.txt");
        int expected =42;
        Map<Character, Integer> expect = new HashMap<>();
        expect.put('с',2);
        expect.put('!',1);
        expect.put('т',4);
        expect.put('у',2);
        expect.put('ь',2);
        expect.put('ю',1);
        expect.put('.',1);
        expect.put('б',1);
        expect.put('в',1);
        expect.put('д',3);
        expect.put('е',5);
        expect.put('ж',1);
        expect.put('З',1);
        expect.put('и',5);
        expect.put('й',1);
        expect.put('к',1);
        expect.put('л',1);
        expect.put('м',1);
        expect.put('н',4);
        expect.put('о',4);
        expect.put('п',2);

        int actual =test.countLetters();
        assertEquals("Frequency analysis check", expected, actual,0.1);
    }

}