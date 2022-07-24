package Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] lenght = new int[sequence.length];
        int[] prev = new int[sequence.length];

        Arrays.fill(prev, -1);

        int maxLenght = 0, maxIndex = -1;

        for (int i = 0; i < sequence.length; i++) {
            int current = sequence[i];
            int bestLenght = 1;
            int bestIndex = -1;

            for (int j = i; j >= 0; j--) {
                if (sequence[j] < current && lenght[j] + 1 >= bestLenght) {
                    bestLenght = lenght[j] + 1;
                    bestIndex = j;
                }
            }
            prev[i] = bestIndex;
            lenght[i] = bestLenght;
            if (maxLenght < bestLenght) {
                maxLenght = bestLenght;
                maxIndex = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        int index = maxIndex;

        while (index != -1) {
            list.add(sequence[index]);
            index = prev[index];
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}
