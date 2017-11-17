package main.java;

import java.util.ArrayList;
import java.util.Stack;

public class Calculator {

    public static double Calculate(String expresion) {
        if(expresion==null||expresion==""){
            return 0;
        }
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
            priority = GetPriority(i);

            if (priority == 0) {
                result.add(i);
            }

            else if (priority == 1) {
                stack.push(i);
            }

            else if (priority == 2) {
                String symbol = (String) stack.pop();
                while (GetPriority(symbol)!=1 && !stack.empty()) {
                    result.add(symbol);
                    symbol = (String) stack.pop();
                }
                continue;
            }

            else if (IsOperator(i)) {
                while (!stack.empty() && GetPriority((String) stack.peek()) >= priority) {
                    result.add((String) stack.pop());
                }
                stack.push(i);
            }
        }

        while (!stack.empty()) {
            result.add((String) stack.pop());
        }

        return result;
    }

    private static ArrayList StringtoList(String ch) {
        ArrayList<String> result = new ArrayList();
        char[] input = ch.toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (" ".indexOf(input[i])==1){
                continue;
            } else if (Character.isDigit(input[i])) {
                String b = "";
                while (!IsDelimeter(String.valueOf(input[i])) && !IsOperator(String.valueOf(input[i]))) {
                    b += input[i];
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

            if (sNumber(i)) {
                stack.push(Double.parseDouble((i)));

            } else if (IsOperator(i)) {

                double a = (double) stack.pop();
                double b = (double) stack.pop();

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
                stack.push(rezult);
            }
        }
        return (double) stack.peek();
    }

    private static boolean IsDelimeter(String ch) { 
        if (("()".indexOf(ch) != -1))
            return true;
        return false;
    }

    private static boolean IsOperator(String сh) { 
        if (("+-/*".indexOf(сh) != -1))
            return true;
        return false;
    }

    private static int GetPriority(String ch) {
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

