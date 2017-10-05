public class Main {
    public static void FizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println("FIZZBUZZ");
            } else if (i % 3 == 0) {
                System.out.println("FIZZ");
            } else if (i % 5 == 0) {
                System.out.println("BUZZ");
            } else {
                System.out.println(i);
            }
        }
    }

    public static boolean IsSimple(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean IsCorrect(String sequence) {
        int summa = 0;
        for (int i = 0; i < sequence.length(); i++)
        {
            if (sequence.charAt(i)=='(')
            {
                summa++;
            }
            else
            {
                summa--;
            }

            if (summa < 0)
            {
                return false;
            }

        }

        return summa==0;
    }

    public static void main(String[] args) {
        FizzBuzz();

        System.out.println(IsSimple(20));

        String mas = "((((())(";
        System.out.println(IsCorrect(mas));
    }
}