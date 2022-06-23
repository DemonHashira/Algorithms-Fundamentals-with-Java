package Tasks;

import java.util.Scanner;

public class GeneratingVectors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];
        generatingVectors(0, array);
    }

    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j);
        }
        System.out.println();
    }

    public static void generatingVectors(int index, int[] array) {
        if (index >= array.length) {
            printArray(array);
        } else {
            for (int i = 0; i <= 1; i++) {
                array[index] = i;
                generatingVectors(index + 1, array);
            }
        }
    }
}
