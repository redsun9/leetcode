package advent.year2023.day22.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;
import static java.util.Comparator.comparingInt;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
//                FileInputStream fis = new FileInputStream("src/advent/year2023/day22/example.txt");
                FileInputStream fis = new FileInputStream("src/advent/year2023/day22/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day22/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            printer.println(solve(parseInput(scanner)));
        }
    }

    private static List<int[]> parseInput(Scanner scanner) {
        List<int[]> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (!s.isBlank()) {
                String[] split = s.split("\\D+");
                int[] block = new int[6];
                for (int i = 0; i < 6; i++) block[i] = Integer.parseInt(split[i]);
                input.add(block);
            }

        }
        return input;
    }

    private static int solve(List<int[]> input) {
        int n = input.size();
        input.sort(comparingInt(x -> x[2]));
        Set<Integer>[] dependents = new Set[n + 1];
        int[] numberOfDependencies = new int[n + 1];
        for (int i = 0; i <= n; i++) dependents[i] = new HashSet<>();

        int minX = MAX_VALUE, maxX = Integer.MIN_VALUE, minY = MAX_VALUE, maxY = Integer.MIN_VALUE;
        for (int[] block : input) {
            minX = Math.min(minX, block[0]);
            maxX = Math.max(maxX, block[3]);
            minY = Math.min(minY, block[1]);
            maxY = Math.max(maxY, block[4]);
        }

        int[][][] maximumsForColumns = new int[maxX - minX + 1][maxY - minY + 1][2];
        for (int idx = 1; idx <= n; idx++) {
            int[] block = input.get(idx - 1);
            int maxH = 0;
            for (int i = block[0] - minX; i <= block[3] - minX; i++) {
                for (int j = block[1] - minY; j <= block[4] - minY; j++) {
                    maxH = Math.max(maxH, maximumsForColumns[i][j][0]);
                }
            }

            for (int i = block[0] - minX; i <= block[3] - minX; i++) {
                for (int j = block[1] - minY; j <= block[4] - minY; j++) {
                    if (maxH == maximumsForColumns[i][j][0]) {
                        if (dependents[maximumsForColumns[i][j][1]].add(idx)) numberOfDependencies[idx]++;
                    }
                }
            }

            int newH = maxH + block[5] - block[2] + 1;
            for (int i = block[0] - minX; i <= block[3] - minX; i++) {
                for (int j = block[1] - minY; j <= block[4] - minY; j++) {
                    maximumsForColumns[i][j][0] = newH;
                    maximumsForColumns[i][j][1] = idx;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) ans += calculateForNode(dependents, numberOfDependencies, i);
        return ans;

    }

    private static int calculateForNode(Set<Integer>[] dependents, int[] numberOfDependencies, int node) {
        Queue<Integer> nodesToProcess = new ArrayDeque<>();
        numberOfDependencies = Arrays.copyOf(numberOfDependencies, numberOfDependencies.length);
        nodesToProcess.offer(node);

        int ans = 0;
        while (!nodesToProcess.isEmpty()) {
            Integer u = nodesToProcess.poll();
            for (Integer v : dependents[u]) {
                if (--numberOfDependencies[v] == 0) {
                    nodesToProcess.offer(v);
                    ans++;
                }
            }
        }
        return ans;
    }
}
