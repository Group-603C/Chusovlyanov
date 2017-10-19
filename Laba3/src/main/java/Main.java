package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String expresion = InputArray();
        Calculator input = new Calculator();
        double rezult = input.Calculate(expresion);
        System.out.println("Результат: " + rezult);
    }

    public static boolean IsCorrect(String sequence) {
        int summa = 0;
        int number = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == '(') {
                summa++;
                number++;
            } else if ("0123456789-+=/* ".indexOf(sequence.charAt(i)) != -1) {
                continue;
            } else {
                summa--;
                number++;
            }
 
            if (summa < 0) {
                return false;
            }
        }
        if (number == sequence.length()) {
            return false;
        }

        return summa == 0;
    }

    public static String InputArray() {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Введите выражение");
            String in = input.next();

            int i = 0;
            try {
                while (i < in.length()) {
                    if ("0123456789()-+=/* ".indexOf(in.charAt(i)) == -1) {
                        throw new Error();
                    }
                    i++;
                }
                if (!IsCorrect(in)) {
                    throw new Error();
                }

                return in;

            } catch (Error e) {
                System.out.println("Ошибка,введено не числовое значение!");
            }
        }
    }

}