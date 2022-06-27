package Tasks;

import java.util.HashSet;
import java.util.Scanner;

class PermutationWithoutrepetition {

    public static String[] permutes;
    public static String[] elements;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");

        permutes = new String[elements.length];

        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print(elements);
        } else {
            permute(index + 1);
            HashSet<String> swapped = new HashSet<>();
            swapped.add(elements[index]);
            for (int i = index + 1; i < elements.length; i++) {
                if (!swapped.contains(elements[i])) {
                    swap(elements, index, i);
                    permute(index + 1);
                    swap(elements, index, i);
                    swapped.add(elements[i]);
                }
            }
        }
    }

    private static void swap(String[] array, int index, int i) {
        String temp = array[index];
        array[index] = array[i];
        array[i] = temp;
    }

    private static void print(String[] elements) {
        System.out.println(String.join(" ", elements));
    }
}
