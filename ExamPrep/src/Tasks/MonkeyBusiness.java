package Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MonkeyBusiness {
    public static int[] numbers;
    public static int[] expressions;
    public static int solutions;
    public static int n;
    public static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());

        numbers = IntStream.rangeClosed(1, n).toArray();

        expressions = new int[n];

        variantions(0, n);

        System.out.println(output.toString().trim());

        System.out.println("Total Solutions: " + solutions);
    }

    private static void variantions(int index, int n) {
        if (index >= n) {
            printSolution();
            return;
        }
        expressions[index] = numbers[index];
        variantions(index + 1, n);

        expressions[index] = -numbers[index];
        variantions(index + 1, n);
    }

    private static void printSolution() {
        int sum = Arrays.stream(expressions).sum();

        if (sum == 0) {
            solutions++;
            for (int expression : expressions) {
                String formatedNumber = expression > 0 ? "+" + expression : String.valueOf(expression);
                output.append(formatedNumber).append(" ");
            }
            output.append(System.lineSeparator());
        }
    }
}