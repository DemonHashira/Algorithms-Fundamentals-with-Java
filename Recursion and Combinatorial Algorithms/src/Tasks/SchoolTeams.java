package Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolTeams {
    public static String[] boys;
    public static String[] boysCombinations = new String[2];
    public static String[] girls;
    public static String[] girlCombinations = new String[3];
    public static List<String> allBoys = new ArrayList<>();
    public static List<String> allGirls = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        girls = scanner.nextLine().split(", ");
        boys = scanner.nextLine().split(", ");

        combinateGirls(0, 0);
        combinateBoys(0, 0);

        for (String allGirl : allGirls) {
            for (String allBoy : allBoys) {
                System.out.println(allGirl + ", " + allBoy);
            }
        }
    }

    private static void combinateBoys(int index, int start) {
        if (index == boysCombinations.length) {
            allBoys.add(String.join(", ", boysCombinations));
        } else {
            for (int i = start; i < boys.length; i++) {
                boysCombinations[index] = boys[i];
                combinateBoys(index + 1, i + 1);
            }
        }
    }

    private static void combinateGirls(int index, int start) {
        if (index == girlCombinations.length) {
            allGirls.add(String.join(", ", girlCombinations));
        } else {
            for (int i = start; i < girls.length; i++) {
                girlCombinations[index] = girls[i];
                combinateGirls(index + 1, i + 1);
            }
        }
    }
}
