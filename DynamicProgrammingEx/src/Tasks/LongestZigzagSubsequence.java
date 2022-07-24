package Tasks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class LongestZigzagSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[numbers.length + 1][2];
        int[][] prev = new int[numbers.length][2];

        dp[0][0] = 1;
        dp[0][1] = 1;

        prev[0][0] = -1;
        prev[0][1] = -1;

        int maxLength = 0;

        int[] bestSolutions = new int[2];

        for (int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {
            int currentNumber = numbers[currentIndex];
            for (int prevIndex = currentIndex - 1; prevIndex >= 0; prevIndex--) {
                int prevNumber = numbers[prevIndex];
                if (currentNumber > prevNumber && dp[currentIndex][0] <= dp[prevIndex][1] + 1) {
                    dp[currentIndex][0] = dp[prevIndex][1] + 1;
                    prev[currentIndex][0] = prevIndex;
                }
                if (currentNumber < prevNumber && dp[currentIndex][1] <= dp[prevIndex][0] + 1) {
                    dp[currentIndex][1] = dp[prevIndex][0] + 1;
                    prev[currentIndex][1] = prevIndex;
                }
            }
            if (maxLength < dp[currentIndex][0]) {
                maxLength = dp[currentIndex][0];
                bestSolutions[0] = currentIndex;
                bestSolutions[1] = 0;
            } else if (maxLength < dp[currentIndex][1]) {
                maxLength = dp[currentIndex][1];
                bestSolutions[0] = currentIndex;
                bestSolutions[1] = 1;
            }
        }
        Deque<Integer> zigZagsequence = new ArrayDeque<>();

        int beginRow = bestSolutions[0];
        while (beginRow >= 0) {
            zigZagsequence.push(numbers[beginRow]);
            beginRow = prev[beginRow][bestSolutions[1]];
            bestSolutions[1] = bestSolutions[1] == 0 ? 1 : 0;
        }

        while (!zigZagsequence.isEmpty()) {
            System.out.print(zigZagsequence.pop() + " ");
        }
    }
}
