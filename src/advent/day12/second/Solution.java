package advent.day12.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day12/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day12/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            HashMap<String, Integer> nameMap = new HashMap<>();
            List<Cave> caves = new ArrayList<>();

            List<List<Integer>> adj = new ArrayList<>();
            int numberOfCaves = 0;
            int numberOfSmallCaves = 0;

            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().trim().split("-");
                Integer u = nameMap.get(parts[0]);
                if (u == null) {
                    u = numberOfCaves++;
                    adj.add(new ArrayList<>());
                    nameMap.put(parts[0], u);
                    boolean isSmall = Character.isLowerCase(parts[0].charAt(0));
                    caves.add(new Cave(isSmall, numberOfSmallCaves));
                    if (isSmall) numberOfSmallCaves++;
                }
                Integer v = nameMap.get(parts[1]);
                if (v == null) {
                    v = numberOfCaves++;
                    adj.add(new ArrayList<>());
                    nameMap.put(parts[1], v);
                    boolean isSmall = Character.isLowerCase(parts[1].charAt(0));
                    caves.add(new Cave(isSmall, numberOfSmallCaves));
                    if (isSmall) numberOfSmallCaves++;
                }

                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            long[] cache = new long[numberOfCaves << (numberOfSmallCaves + 1)];

            int start = nameMap.get("start"), end = nameMap.get("end");
            int maskForSmallCaves = (1 << numberOfSmallCaves) - 1;
            int key = start << (numberOfSmallCaves + 1); // u,usedSecondTime,visitedSmall
            long ans = dfs(start, key, start, end, numberOfSmallCaves, maskForSmallCaves, adj, caves, cache);

            printer.println(ans);
        }
    }


    private static long dfs(
            int u, int key, int start, int end,
            int numberOfSmallCaves, int maskForSmallCaves,
            List<List<Integer>> adj, List<Cave> caves, long[] cache
    ) {
        if (u == end) return 1;
        if (cache[key] == 0) {
            long tmp = 1;
            int fromKey = key & maskForSmallCaves;
            int visitedBefore = key >>> numberOfSmallCaves & 1;

            if (caves.get(u).isSmall) {
                visitedBefore |= key >> caves.get(u).smallCaveIdx & 1;
                fromKey |= 1 << caves.get(u).smallCaveIdx;
            }
            if (visitedBefore != 0) {
                fromKey |= 1 << numberOfSmallCaves;
                for (Integer v : adj.get(u)) {
                    if (v != start && (!caves.get(v).isSmall || (key >>> caves.get(v).smallCaveIdx & 1) == 0)) {
                        tmp += dfs(v, fromKey | v << (numberOfSmallCaves + 1), start, end, numberOfSmallCaves, maskForSmallCaves, adj, caves, cache);
                    }
                }
            } else {
                for (Integer v : adj.get(u)) {
                    if (v != start) {
                        tmp += dfs(v, fromKey | v << (numberOfSmallCaves + 1), start, end, numberOfSmallCaves, maskForSmallCaves, adj, caves, cache);
                    }
                }
            }

            cache[key] = tmp;
        }
        return cache[key] - 1;
    }


    private static class Cave {
        private final boolean isSmall;
        private final int smallCaveIdx;

        public Cave(boolean isSmall, int smallCaveIdx) {
            this.isSmall = isSmall;
            this.smallCaveIdx = smallCaveIdx;
        }
    }
}
