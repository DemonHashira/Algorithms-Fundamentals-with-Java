package Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Numbers {
    public static int n;

    public static List<String> values;

    public static Deque<String> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());

        deque = new ArrayDeque<>();

        ArrayList<Integer> arr = new ArrayList<Integer>();

        values = new ArrayList<>();

        System.out.println(n);

        findWays(arr, 1, n);

        Collections.reverse((List<?>) deque);
        System.out.println(String.join(" + ", deque));
    }

    public static void findWays(ArrayList<Integer> arr, int i, int n) {
        if (n == 0) {
            printSolution(arr);
        }
        for (int j = i; j <= n; j++) {
            deque.add(String.valueOf(j));
            arr.add(j);
            findWays(arr, j, n - j);
            arr.remove(arr.size() - 1);
        }
    }

    public static void printSolution(ArrayList<Integer> arr) {
        List<String> listOfString = convertIntListToStringList(arr, String::valueOf);
        if (listOfString.size() != 1) {
            Collections.reverse(listOfString);
            System.out.print(String.join(" + ", listOfString));
            System.out.println();
            Collections.reverse(listOfString);
        }
        Collections.reverse(listOfString);
    }

    public static <T, U> List<U> convertIntListToStringList(List<T> listOfInteger, Function<T, U> function) {
        return listOfInteger.stream()
                .map(function)
                .collect(Collectors.toList());
    }
}
