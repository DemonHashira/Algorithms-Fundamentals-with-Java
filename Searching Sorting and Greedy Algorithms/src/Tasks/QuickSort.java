package Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();

        quickSort(array, 0, array.length - 1);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(array, left, right);

        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);

    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];

        int k = left - 1;

        for (int i = left; i <= right; i++) {
            if (array[i] <= pivot) {
                k++;
                swap(array, k, i);
            }
        }
        return k;
    }

    private static void swap(int[] array, int k, int i) {
        int temp = array[k];
        array[k] = array[i];
        array[i] = temp;
    }
}
