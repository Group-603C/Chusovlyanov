
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String expresion = "(4*5)-(56-20)";
        double a = Calculate(expresion);
        System.out.println(a);
    }

    public static double Calculate(String expresion) {
        String postfix = GetExpression(expresion);
        double rezult = Counting(postfix);
        return rezult;
    }

    private static boolean IsDelimeter(char ch) { //метод возвращает true,если проверяемый символ разделитель
        if ((" =".indexOf(ch) != -1))
            return true;
        return false;
    }

    private static boolean IsOperator(char сh) { //метод возвращает true, если проверяемый символ - оператор
        if (("+-/*".indexOf(сh) != -1))
            return true;
        return false;
    }

    private static int Priority(char ch) { //метод возврацения приоритета
        switch (ch) {
            case '(':
                return 1;
            case ')':
                return 2;
            case '=':
                return 3;
            case '+':
                return 4;
            case '-':
                return 4;
            case '*':
                return 5;
            case '/':
                return 5;
            case ' ':
                return -1;
            default:
                return 0;
        }
    }

    private static double Counting(String postfix) {
        double rezult = 0;
        Stack temp = new Stack();
        char[] str = postfix.toCharArray();

        for (int i = 0; i < str.length; i++) {

            if (Character.isDigit(str[i])) { //если символ - цифра, то читаем все число и записываем на вершину стека
                String a = "";

                while (!IsDelimeter(str[i]) && !IsOperator(str[i])) {//пока не разделитель
                    a += str[i];//собираем число
                    i++;

                    if (i == str.length) {
                        break;
                    }
                }
                temp.push(Double.parseDouble(a));//записываем в стек
                i--;

            } else if (IsOperator(str[i])) { //если символ -оператор
                //берем числа из стека
                double a = (double) temp.pop();
                double b = (double) temp.pop();
                //выполняем операции над ними
                switch (str[i]) {
                    case '+':
                        rezult = b + a;
                        break;
                    case '-':
                        rezult = b - a;
                        break;
                    case '*':
                        rezult = b * a;
                        break;
                    case '/':
                        rezult = b / a;
                        break;
                }
                temp.push(rezult);//результат возвращаем в стек
            }
        }
        return (double) temp.peek();//возвращаем результат всех вычислений
    }

    private static String GetExpression(String expresion) {
        int x;
        String postfix = "";
        Stack st = new Stack();
        char[] str = expresion.toCharArray();
        for (int i = 0; i < str.length; i++) {
            x = Priority(str[i]);//находим приоритет символа
            if (x == -1) {//Если символ пробел- пропускаем
                continue;
            }
            if (x == 0 || x == 3) {//Если символ цифра или равно
                while (x == 0 && i < str.length) {//пока цифр
                    postfix += str[i];//добавляем каждую цифру числа к нашей строке
                    i++;
                    if (i == str.length) {//если символ последний выходим
                        break;
                    }
                    x = Priority(str[i]);
                }
                postfix += " ";//дописываем пробел
                i--;
                continue;
            }
            if (x == 1) { //если скобка открывается
                st.push(str[i]);//добавляем к стек
                continue;
            }
            if (x == 2) {//если скобка закрывается
                char symbol = (char) st.pop();
                while (symbol != '(' && !st.empty()) { //пока не окрывающияся скобка или не конец стека
                    postfix += symbol + " ";//записываем операции в строку
                    symbol = (char) st.pop();
                }
                continue;
            }
            if (x == 4 || x == 5) {//если  +-/*
                while (!st.empty() && Priority((char) st.peek()) >= x) {//пока не конец стека и приоритет оператора в стеке больше оператора в строке
                    postfix += (char) st.pop() + " ";//извлекаем из стека в строку
                }
                st.push(str[i]);//заносим новый оператор в строку
            }
        }
        while (!st.empty()) {//забираем последнии символы из стека 
            postfix += (char) st.pop() + " ";
        }
        return postfix;//возвращаем выражение в постфиксной записи
    }
}