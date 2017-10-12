
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        String expresion = "(4*5)-(56-20)" ;
        double a= Calculate (expresion);
        System.out.println(a);
    }
    public static double Calculate  (String expresion){
        String postfix = GetExpression(expresion);
        double rezult =Counting(postfix);
        return rezult;
    }

    private static boolean IsDelimeter(char ch) {
        if ((" =".indexOf(ch) != -1))
            return true;
        return false;
    }

    private static boolean IsOperator(char сh) {
        if (("+-/*".indexOf(сh) != -1))
            return true;
        return false;
    }

    private static int Priority (char ch){
        switch (ch){
            case '(':return 1;
            case ')':return 2;
            case '=':return 3;
            case '+':return 4;
            case '-':return 4;
            case '*':return 5;
            case '/':return 5;
            case ' ':return -1;
            default:return 0;
        }
    }

    private static double Counting  (String postfix) {
        double rezult = 0;
        Stack temp = new Stack();
        char[] str = postfix.toCharArray();
        for (int i=0;i<str.length;i++) {
            if (Character.isDigit(str[i])) {
                String a = "";
                while (!IsDelimeter(str[i]) && !IsOperator(str[i])) {
                    a += str[i];
                    i++;
                    if (i == str.length) {
                        break;
                    }
                }
                temp.push(Double.parseDouble(a));
                i--;
            } else if (IsOperator(str[i])) {
                double a = (double) temp.pop();
                double b = (double) temp.pop();
                switch (str[i]) {
                    case '+':
                        rezult = b + a;break;
                    case '-':
                        rezult = b - a;break;
                    case '*':
                        rezult = b * a;break;
                    case '/':
                        rezult = b / a;break;
                }
                temp.push(rezult);
            }
        }
        return (double) temp.peek();
    }

    private static String GetExpression  (String expresion){
        int x;
        String postfix = "";
        Stack st= new Stack();
        char[] str = expresion.toCharArray();
        for(int i=0;i<str.length;i++) {
            x = Priority(str[i]);
            if(x==-1){
                continue;
            }
            if (x == 0 || x == 3) {
                while (x==0&&i<str.length){
                    postfix += str[i];
                    i++;
                    if(i==str.length){
                        break;
                    }
                    x = Priority(str[i]);
                }
                postfix += " ";
                i--;
                continue;
            }
            if (x == 1) {
                st.push(str[i]);
                continue;
            }
            if (x == 2) {
                char symbol = (char) st.pop();
                while (symbol != '(' && st.empty() == false) {
                    postfix += symbol+" ";
                    symbol = (char) st.pop();
                }
                continue;
            }
            if (x == 4 || x == 5) {
                while (st.empty()==false && Priority((char) st.peek()) >= x) {
                    postfix += (char) st.pop()+" ";
                }
                st.push(str[i]);
            }
        }
        while (!st.empty()){
            postfix+=(char)st.pop()+" ";
        }
        return postfix;
    }
}