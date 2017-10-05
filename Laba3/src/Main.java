import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        String expresion = "(3+10)-2*(1-4)";
        String a= PostfixTranslation(expresion);
        System.out.println(a);
    }

    public static int Priorities(char sign){
            int prior;
            switch (sign){
                case '(':prior=1;break;
                case ')':prior=2;break;
                case '=':prior=3;break;
                case '+':prior=4;break;
                case '-':prior=4;break;
                case '*':prior=5;break;
                case '/':prior=5;break;
                default:prior=0;
            }
            return prior;
    }
  //  public static int Calculate (String expresion){

    //}
    public static String PostfixTranslation (String expresion){
        int x;
        String postfix = "";
        Stack st= new Stack();
        char[] str = expresion.toCharArray();
        for(int i=0;i<str.length;i++) {
            x = Priorities(str[i]);
            if (x == 0 || x == 3) {
                postfix += str[i];
                continue;
            }
            if (x == 1) {
                st.push(str[i]);
                continue;
            }
            if (x == 2) {
                char symbol = (char) st.pop();
                while (symbol != '(' && st.empty() == false) {
                    postfix += symbol;
                    symbol = (char) st.pop();
                }
                continue;
            }
            if (x == 4 || x == 5) {
                while (st.empty()==false && Priorities((char) st.peek()) >= x) {
                    postfix += (char) st.pop();
                }
                st.push(str[i]);
            }
        }
        while (!st.empty()){
            postfix+=(char)st.pop();
        }
        return postfix;
    }
}
