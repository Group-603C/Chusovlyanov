package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String expression = InputArray();
        Calculator input = new Calculator();
        double result = Calculator.Calculate(expression);
        System.out.println("Результат: " + result);
    }

    public static boolean IsCorrect(String sequence) {
        int sum = 0, number = 0;

        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == '(') {
                sum++;
                number++;

            } else if ("0123456789-+/*".indexOf(sequence.charAt(i)) != -1) {
                continue;

            } else {
                sum--;
                number++;
            }

            if (sum < 0) {
                return false;
            }

        }
        if (number == sequence.length()) {
            return false;
        }

        return sum == 0;
    }

    public static String InputArray() {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите выражение");
            String input = in.next();

            try {
                int count = 0;
                while (count < input.length()) {
                    if ("0123456789()-+/*".indexOf(input.charAt(count)) == -1) {
                        throw new Error();
                    }
                    count++;
                }
                if (!IsCorrect(input)) {
                    throw new Error();
                }

                return input;

            } catch (Error e) {
                System.out.println("Ошибка,введено не числовое значение!");
            }
        }
    }

}
