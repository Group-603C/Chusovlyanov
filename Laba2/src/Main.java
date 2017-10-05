import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int FindMaximum(int[] array) {
        int max = Integer.MIN_VALUE;

        if (array == null||array.length == 0) {
            return max;
        }

        for (int i: array) {
            max=Math.max(max,i);
        }
        return max;
    }

    public static int FindMinimum(int[] array) {
        int min = Integer.MAX_VALUE;

        if (array == null||array.length == 0) {
            return min;
        }

        for (int i: array) {
            min=Math.min(min,i);
        }

        return min;
    }

    public static double FindAverage(int[] array) {
        if (array == null||array.length == 0) {
            return 0;
        }

        int summa = 0;
        for (int i: array) {
            summa += i ;
        }

        return (double) summa / array.length;
    }

    public static double FindMedian(int[] array) {

        if (array == null||array.length == 0) {
            return 0;
        }
        int[] copyArray=array.clone();
        Arrays.sort(copyArray);
        int length=copyArray.length/2;
        if (array.length % 2 != 0) {
            return copyArray[length];
        } else {
            return FindAverage(new int[]{copyArray[length],copyArray[length-1]}) ;
        }
    }

    public static double FindGeometricAverage(int[] array) {

        if (array == null||array.length == 0) {
            return 0;
        }

        double product = 1;
        for (int i: array) {
            if (i == 0) {
                return 0;
            } else {
                product = product * i;
            }
        }
        if(product<0)
        {
            return 0;
        }
        return (double) Math.pow(product, 1d / array.length);
    }

    public static int[] InputArray() {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Введите количество чисел ");
                int length = input.nextInt();
                int[] nums = new int[length];
                int i = 0;
                while (i < length) {
                    Scanner intInput = new Scanner(System.in);
                    System.out.println("Введите значение ");
                    String temp = intInput.nextLine();
                    try {
                        int inputInt = Integer.parseInt(temp);
                        nums[i] = inputInt;
                        i++;
                    } catch (NumberFormatException error) {
                        System.out.println("Ошибка введено не числовое значение!");
                    }
                }
                return nums;
            } catch (InputMismatchException error) {
                System.out.println("Ошибка,введено не числовое значение!");
            }
        }
    }

    public static void main(String[] args) {
        int[] array = InputArray();
        System.out.println("Максимальное: " + FindMaximum(array));
        System.out.println("Минимальное " + FindMinimum(array));
        System.out.println("Среднее арефметическое: " + FindAverage(array));
        System.out.println("Медиана: " + FindMedian(array));
        System.out.println("Среднее геометрическое: " + FindGeometricAverage(array));
    }
}
