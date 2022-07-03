package Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NestedLoopsToRecursion {
    public static int[] elements;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        elements = new int[n];

        variations(0);
    }
    private static void variations(int index) {
        if (index == elements.length) {
            print(elements);
        } else {
            for (int i = 1; i <= n; i++) {
                elements[index] = i;
                variations(index + 1);
            }
        }
    }
    private static void print(int[] elements) {
        for (int element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
