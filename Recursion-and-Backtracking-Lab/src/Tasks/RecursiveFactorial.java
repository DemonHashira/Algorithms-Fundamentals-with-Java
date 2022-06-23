package Tasks;

import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = Long.parseLong(scanner.nextLine());

        System.out.println(factorial(num));
    }

    public static long factorial(long num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}
