package Tasks;

import java.util.*;

public class CyclesInAGraph {

    public static Map<String, List<String>> graph = new HashMap<>();
    public static boolean isCycle;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        String source = null;

        while (!line.equals("End")) {

            String[] tokens = line.split("-");

            if (source == null) {
                source = tokens[0];
            }

            graph.putIfAbsent(tokens[0], new ArrayList<>());

            graph.get(tokens[0]).add(tokens[1]);

            line = scanner.nextLine();
        }

        Set<String> visited = new HashSet<>();
        Set<String> cycles = new HashSet<>();


        dfs(source, visited, cycles);
        if (isCycle) {
            System.out.println("Acyclic: No");
        } else {
            System.out.println("Acyclic: Yes");
        }
    }

    private static void dfs(String source, Set<String> visited, Set<String> cycles) {
        if (cycles.contains(source)) {
            isCycle = true;
            return;
        }
        if (visited.contains(source) || isCycle) {
            return;
        }
        cycles.add(source);
        visited.add(source);

        List<String> children = graph.get(source);
        if (children == null) {
            return;
        }

        for (String child : graph.get(source)) {
            dfs(child, visited, cycles);
        }
        cycles.remove(source);
    }
}

