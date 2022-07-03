package Tasks;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class WordCruncher {
    public static List<String> words;
    public static String target;
    public static List<String> combined = new ArrayList<>();
    public static Map<Integer, List<String>> table = new HashMap<>();
    public static Map<String, Integer> occurances = new HashMap<>();
    public static Set<String> out = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        words = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        target = scanner.nextLine();

        words.removeIf(next -> !target.contains(next));

        for (String substr : words) {
            occurances.putIfAbsent(substr, 0);
            occurances.put(substr, occurances.get(substr) + 1);
            int index = target.indexOf(substr);
            while (index != -1) {
                table.putIfAbsent(index, new ArrayList<>());
                table.get(index).add(substr);
                index = target.indexOf(substr, index + 1);
            }
        }
        permute(0);

        for (String str : out) {
            System.out.println(str);
        }
    }

    private static void permute(int index) {
        if (index == target.length()) {
            print();
        } else if (table.containsKey(index)) {
            List<String> strings = table.get(index);
            for (String str : strings) {
                if (occurances.get(str) > 0) {
                    occurances.put(str, occurances.get(str) - 1);
                    combined.add(str);
                    permute(index + str.length());
                    combined.remove(combined.size() - 1);
                    occurances.put(str, occurances.get(str) + 1);
                }
            }
        }
    }

    private static void print() {
        String actual = String.join("", combined);
        if (actual.contains(target)) {
            out.add(String.join(" ", combined));
        }
    }
}
