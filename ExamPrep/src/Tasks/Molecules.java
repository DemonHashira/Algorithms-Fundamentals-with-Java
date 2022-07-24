package Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Molecules {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edge = Integer.parseInt(reader.readLine());

        int[][] graph = new int[nodes + 1][nodes + 1];

        while (edge-- > 0) {
            int[] edges = Arrays.stream(reader.readLine().split("\\s++"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int from = edges[0];
            int to = edges[1];

            graph[from][to] = 1;
        }
        int start = Integer.parseInt(reader.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        deque.offer(start);

        boolean[] visited = new boolean[nodes + 1];

        while (!deque.isEmpty()) {
            int node = deque.poll();
            visited[node] = true;

            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    deque.offer(i);
                }
            }
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
