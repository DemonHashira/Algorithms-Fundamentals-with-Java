package Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClusterBorder {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] singleEntryTimes = Arrays.stream(reader.readLine().split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] combinedEntryTimes = Arrays.stream(reader.readLine().split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] memory = new int[singleEntryTimes.length + 1];

        memory[0] = 0;
        memory[1] = singleEntryTimes[0];

        for (int i = 2; i <= singleEntryTimes.length; i++) {
            int singleShipTime = memory[i - 1] + singleEntryTimes[i - 1];
            int pairShipTime = memory[i - 2] + combinedEntryTimes[i - 2];
            memory[i] = Math.min(singleShipTime, pairShipTime);
        }
        System.out.println("Optimal Time: " + memory[memory.length - 1]);

        int index = memory.length - 1;

        List<String> outputLines = new ArrayList<>();

        while (index > 0) {
            String line;
            if (memory[index - 1] + singleEntryTimes[index - 1] == memory[index]) {
                line = "Single " + index;
                index--;
            } else {
                line = "Pair of " + (index - 1) + " and " + index;
                index -= 2;
            }
            outputLines.add(line);
        }
        Collections.reverse(outputLines);

        System.out.println(String.join(System.lineSeparator(), outputLines));
    }
}
