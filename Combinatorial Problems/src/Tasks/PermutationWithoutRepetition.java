package Tasks;

import java.util.Scanner;

public class PermutationWithoutRepetition {
    public static String[] permutations;
    public static String[] elements;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");

        permutations = new String[elements.length];

        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print(elements);
        } else {
            permute(index + 1);
            for (int i = index + 1; i < elements.length; i++) {
                swap(elements, index, i);
                permute(index + 1);
                swap(elements, index, i);
            }
        }
    }

    private static void swap(String[] elements, int index, int i) {
        String temp = elements[index];
        elements[index] = elements[i];
        elements[i] = temp;
    }

    private static void print(String[] elements) {
        System.out.println(String.join(" ", elements));
    }
}