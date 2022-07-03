package Tasks;

import java.util.Scanner;

public class CombinationsWithoutRep {
    public static int[] combinations;
    public static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        combinations = new int[k];

        combinate(0, 1);
    }
    private static void combinate(int index, int start) {
        if (index == combinations.length) {
            print(combinations);
        } else {
            for (int i = start; i <= n; i++) {
                combinations[index] = i;
                combinate(index + 1, i);
            }
        }
    }
    private static void print(int[] combinations) {
        for (int combination : combinations) {
            System.out.print(combination + " ");
        }
        System.out.println();
    }
}
