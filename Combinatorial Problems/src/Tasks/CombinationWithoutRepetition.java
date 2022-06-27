package Tasks;

import java.util.Scanner;

public class CombinationWithoutRepetition {

    public static String[] elements;
    public static String[] combinations;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");

        int k = Integer.parseInt(scanner.nextLine());

        combinations = new String[k];

        combinate(0, 0);
    }

    private static void combinate(int index, int start) {
        if (index == combinations.length) {
            print(combinations);
        } else {
            for (int i = start; i < elements.length; i++) {
                combinations[index] = elements[i];
                combinate(index + 1, i + 1);
            }
        }
    }

    private static void print(String[] combinations) {
        System.out.println(String.join(" ", combinations));
    }
}
