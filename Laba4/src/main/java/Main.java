package main.java;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args)throws FileNotFoundException {
        FileAnalizer analysis = new FileAnalizer("input.txt");
        System.out.println("Количество букв: "+analysis.countLetters());
        System.out.println("Количетво слов :"+analysis.countWords());
        System.out.println("Количество строк :"+analysis.countLines());
        System.out.println("Частотный анализ :"+analysis.countFrequencyCharacteristic());
    }
}
