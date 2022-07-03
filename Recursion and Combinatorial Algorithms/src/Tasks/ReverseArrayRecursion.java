package Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArrayRecursion {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] array = reader.readLine().split("\\s+");

        printRevArr(array, array.length - 1);
    }

    private static void printRevArr(String[] array, int index) {
        if (index < 0) {
            return;
        }
        System.out.print(array[index] + " ");
        printRevArr(array, index - 1);
    }
}