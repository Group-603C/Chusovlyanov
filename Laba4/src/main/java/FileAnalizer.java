package main.java;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.toLowerCase;

public class FileAnalizer {

    private char[] text;

    public FileAnalizer(String path) throws FileNotFoundException {

        exists(path);
        String dataStream = new String();
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(path), "Cp1251"));
            try {
                String line;

                while ((line = input.readLine()) != null) {
                    dataStream+=line;
                    dataStream+= "\n";
                }

            }
            finally {
                input.close();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        text = dataStream.toCharArray();
    }

    private static void exists(String fileName) throws FileNotFoundException {

        File file = new File(fileName);

        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

    public int countLetters() {

        int count = 0;

        for (char i : text) {

            if (checkForLetter(i)) {
                count++;
            }
        }

        return count;
    }

    private static boolean checkForLetter(char symbol) {

        if (((symbol >= 'а') && (symbol <= 'я')) || ((symbol >= 'А') && (symbol <= 'Я'))) {

            return true;
        }
        else if (((symbol >= 'a') && (symbol <= 'z')) || ((symbol >= 'A') && (symbol <= 'Z'))) {

            return true;
        }

        return false;
    }

    public int countWords() {

        int count = 0;

        for (char i : text) {

            if (i == ' ' || i == '\n') {
                count++;
            }
        }

        return count;
    }

    public int countLines() {
        int count = 0;

        for (char i : text) {

            if (i == '\n') {
                count++;
            }
        }

        return count;

    }

    public Map<Character, Integer> countFrequencyCharacteristic() {

        Map<Character, Integer> analysisResult = new HashMap<>();

        for (char i : text) {

            if ((i != ' ') && (i != '\n')) {
                if (!analysisResult.containsKey(toLowerCase(i))) {
                    analysisResult.put(toLowerCase(i), 1);
                } else {
                    int count = analysisResult.get(i) + 1;
                    analysisResult.put(i, count);
                }
            }
        }

        return analysisResult;
    }
}
