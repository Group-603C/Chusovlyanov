package main.java;

import java.util.ArrayList;
import java.util.Stack;

public class Calculator {

    public static double Calculate(String expresion) {
        ArrayList<String> postfix = GetExpression(expresion);
        double rezult = Counting(postfix);
        return rezult;
    }

    private static ArrayList<String> GetExpression(String expresion) {
        ArrayList<String> arrayList = StringtoList(expresion);
        ArrayList<String> result = new ArrayList<String>();
        Stack stack = new Stack();
        int priority;
        for (String i : arrayList) {
            priority = GetPriority(i);//находим приоритет символа

            if (priority == 0) {//Если символ цифра или равно
                result.add(i);
            }

            else if (priority == 1) { //если скобка открывается
                stack.push(i);//добавляем к стек
            }

            else if (priority == 2) {//если скобка закрывается
                String symbol = (String) stack.pop();
                while (symbol != "(" && !stack.empty()) { //пока не окрывающияся скобка или не конец стека
                    result.add(symbol);//записываем операции в строку
                    symbol = (String) stack.pop();
                }
            }

            else if (IsOperator(i)) {//если  +-/*
                while (!stack.empty() && GetPriority((String) stack.peek()) >= priority) {//пока не конец стека и приоритет оператора в стеке больше оператора в строке
                    result.add((String) stack.pop());//извлекаем из стека в строку
                }
                stack.push(i);//заносим новый оператор в строку
            }
        }

        while (!stack.empty()) {//забираем последнии символы из стека
            result.add((String) stack.pop());
        }

        return result;//возвращаем выражение в постфиксной записи
    }

    private static ArrayList StringtoList(String ch) {
        ArrayList<String> result = new ArrayList();
        char[] input = ch.toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (" ".indexOf(input[i])==1){
                continue;
            } else if (Character.isDigit(input[i])) {
                String b = "";
                while (!IsDelimeter(String.valueOf(input[i])) && !IsOperator(String.valueOf(input[i]))) {//пока не разделитель
                    b += input[i];//собираем число
                    i++;
                    if (i == input.length) {
                        break;
                    }
                }
                i--;
                result.add(b);
            } else {
                result.add(String.valueOf(input[i]));
            }
        }
        return result;
    }

    private static double Counting(ArrayList<String> postfix) {
        Stack stack = new Stack();
        double rezult = 0;

        for (String i : postfix) {

            if (sNumber(i)) { //если символ - цифра, то читаем все число и записываем на вершину стека
                stack.push(Double.parseDouble((i)));//записываем в стек

            } else if (IsOperator(i)) { //если символ -оператор
                //берем числа из стека
                double a = (double) stack.pop();
                double b = (double) stack.pop();
                //выполняем операции над ними
                switch (i) {
                    case "+":
                        rezult = b + a;
                        break;
                    case "-":
                        rezult = b - a;
                        break;
                    case "*":
                        rezult = b * a;
                        break;
                    case "/":
                        rezult = b / a;
                        break;
                }
                stack.push(rezult);//результат возвращаем в стек
            }
        }
        return (double) stack.peek();//возвращаем результат всех вычислений
    }

    private static boolean IsDelimeter(String ch) { //метод возвращает true,если проверяемый символ разделитель
        if (("()".indexOf(ch) != -1))
            return true;
        return false;
    }

    private static boolean IsOperator(String сh) { //метод возвращает true, если проверяемый символ - оператор
        if (("+-/*".indexOf(сh) != -1))
            return true;
        return false;
    }

    private static int GetPriority(String ch) { //метод возврацения приоритета
        switch (ch) {
            case "(":
                return 1;
            case ")":
                return 2;
            case "+":
            case "-":
                return 3;
            case "*":
            case "/":
                return 4;
            default:
                return 0;
        }
    }

    public static boolean sNumber(String ch) {
        if (ch == null || ch.isEmpty()) return false;
        for (int i = 0; i < ch.length(); i++) {
            if (!Character.isDigit(ch.charAt(i))) return false;
        }
        return true;
    }

}
