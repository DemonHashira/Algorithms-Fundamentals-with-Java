package Tasks;

import java.util.Scanner;

public class VariationsWithoutRepetition {

    public static String[] elements;
    public static String[] kSlots;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");

        int k = Integer.parseInt(scanner.nextLine());

        kSlots = new String[k];

        variations(0);
    }

    private static void variations(int index) {
        if (index == kSlots.length) {
            print(kSlots);
        } else {
            for (String element : elements) {
                kSlots[index] = element;
                variations(index + 1);
            }
        }
    }

    private static void print(String[] kSlots) {
        System.out.println(String.join(" ", kSlots));
    }
}
