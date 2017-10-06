import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        String expresion = "(3+10)-2*(1-4)";
        int a= Calculate (expresion);
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
                case ' ':prior=-1;break;
                default:prior=0;
            }
            return prior;
    }
    public static int Calculate (String expresion){
        String postfix=PostfixTranslation(expresion);
        Stack number= new Stack();
        Stack znaki= new Stack();
        char[] str = postfix.toCharArray();
        for (int i=0;i<str .length;i++){
            if((char)47<str[i]&&str[i]<(char)58){
                char[] arr = new char[20];
                int j=0;
                while(str[i]!=' '){
                    arr[j] =str[i];
                    j++;
                    i++;
                }
                arr[j]='\0';
                number.push(arr);
            }
            if(str[i]=='/'||str[i]=='*'||str[i]=='-'||str[i]=='+'){
                znaki.push(str[i]);
            }
        }
        int x,result=1;
        char znak;
        while(!number.empty()&&!znaki.empty()){
            znak=(char)znaki.pop();
            result=(int)number.pop();
            x=(int)number.pop();
            if(znak=='-'){
                result=x-result;
            }
            if(znak=='+'){
                result=x+result;
            }
            if(znak=='*'){
                result=x*result;
            }
            if(znak=='/'){
                result=x/result;
            }
        }
        return result;
    }
    public static String PostfixTranslation (String expresion){
        int x;
        String postfix = "";
        Stack st= new Stack();
        char[] str = expresion.toCharArray();
        for(int i=0;i<str.length;i++) {
            x = Priorities(str[i]);
            if(x==-1){
                continue;
            }
            if (x == 0 || x == 3) {
                while (x==0){
                    postfix += str[i];
                    i++;
                    x = Priorities(str[i]);
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
                while (st.empty()==false && Priorities((char) st.peek()) >= x) {
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
