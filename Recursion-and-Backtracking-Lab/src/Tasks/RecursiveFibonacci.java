package Tasks;

import java.util.Scanner;

public class RecursiveFibonacci {
    private static long[] fibonacciCache;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        fibonacciCache = new long[num + 1];

//        if (num >= 1 && num <= 49) {
            System.out.println(printFibonacci(num));
//        }
    }

    public static long printFibonacci(int num) {
        if (num <= 1) {
            return 1;
        }

        if (fibonacciCache[num] != 0 ) {
            return fibonacciCache[num];
        }

        long fibResult = (printFibonacci(num - 1) + printFibonacci(num - 2));
        fibonacciCache[num] = fibResult;
        return fibResult;
    }
}
