import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static boolean[] visited;
    public static int[] prevNodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int edges = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < edges; i++) {
            int[] paths = Arrays.stream(scanner.nextLine().split("\\s++"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph.get(paths[0]).add(paths[1]);
        }

        int source = Integer.parseInt(scanner.nextLine());
        int destination = Integer.parseInt(scanner.nextLine());

        visited = new boolean[n + 1];
        prevNodes = new int[n + 1];

        Arrays.fill(prevNodes, -1);

        bfs(graph, source, destination);

        List<Integer> path = new ArrayList<>();

        path.add(destination);

        int prevNode = prevNodes[destination];

        while (prevNode != -1) {
            path.add(prevNode);
            prevNode = prevNodes[prevNode];

        }
        System.out.println("Shortest path length is: " + (path.size() - 1));

        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    private static void bfs(List<List<Integer>> graph, int source, int destination) {

        Deque<Integer> deque = new ArrayDeque<>();

        deque.offer(source);
        visited[source] = true;

        while ((!deque.isEmpty())) {
            int node = deque.poll();
            if (node == destination) {
                return;
            }
            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    prevNodes[child] = node;
                    deque.offer(child);
                }
            }
        }
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        List<Deque<Integer>> components = new ArrayList<>();

        for (int start = 0; start < graph.size(); start++) {
            if (!visited[start]) {
                components.add(new ArrayDeque<>());
                dfs(start, components, graph, visited);
            }
            System.out.println();
        }
        return components;
    }

    private static void dfs(int node, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;
            for (int child : graph.get(node)) {
                dfs(child, components, graph, visited);
            }
            components.get(components.size() - 1).offer(node);
        }
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = getDependencyCount(graph);

        List<String> sorted = new ArrayList<>();

        while (!graph.isEmpty()) {
            String current = graph.keySet().stream().filter(k -> dependenciesCount.get(k) == 0)
                    .findFirst().orElse(null);

            if (current == null) {
                break;
            }

            for (String child : graph.get(current)) {
                dependenciesCount.put(child, dependenciesCount.get(child) - 1);
            }

            sorted.add(current);
            graph.remove(current);
        }

        if (!graph.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return sorted;
    }

    private static Map<String, Integer> getDependencyCount(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dependenciesCount.putIfAbsent(node.getKey(), 0);
            for (String child : node.getValue()) {
                dependenciesCount.putIfAbsent(child, 0);
                dependenciesCount.put(child, dependenciesCount.get(child) + 1);
            }
        }
        return dependenciesCount;
    }
}
