package main.java;

public class Main {
    public static void main(String[] args) {
        String expresion = "5*3+2*(12-4)";
        Calculator input =new Calculator();
        double rezult =input.Calculate(expresion);
        System.out.println("Результат: "+rezult);
    }
}