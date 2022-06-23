package Tasks;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(findArraySum(array,0));
    }
    public static int findArraySum(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        }
        return array[index] + findArraySum(array, index + 1);
    }
}