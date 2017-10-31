package main.java;

public class Main {
    public static void main(String[] args) {
        String result = Formatter.build("Hello {0}, I am {1} years old", "hell", 15);
        System.out.println(result);
    }
}
