package advent.year2024.day5.second;

import basic.tuples.Pair;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day5/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day5/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            Set<Pair<Integer, Integer>> set = new HashSet<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank() || s.isEmpty()) break;
                String[] split = s.split("\\|");
                set.add(new Pair<>(parseInt(split[0]), parseInt(split[1])));
            }

            long ans = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank() || s.isEmpty()) break;
                String[] split = s.split(",");
                int n = split.length;
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) arr[i] = parseInt(split[i]);
                boolean ok = true;
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (set.contains(new Pair<>(arr[j], arr[i]))) {
                            ok = false;
                            break;
                        }
                    }
                }
                if (!ok) ans += solve(arr, set);
            }

            printer.println(ans);
        }
    }

    @SuppressWarnings("DataFlowIssue")
    private static int solve(int[] arr, Set<Pair<Integer, Integer>> set) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr) {
            adj.put(a, new ArrayList<>());
            count.put(a, 0);
        }
        for (Pair<Integer, Integer> pair : set) {
            if (!adj.containsKey(pair.getA()) || !adj.containsKey(pair.getB())) continue;
            adj.get(pair.getA()).add(pair.getB());
            count.put(pair.getB(), count.get(pair.getB()) + 1);
        }

        int k = arr.length / 2;
        Queue<Integer> queue = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 0) queue.add(entry.getKey());
        }

        while (k-- != 0) {
            int u = queue.poll();
            for (Integer v : adj.get(u)) {
                if (count.put(v, count.get(v) - 1) == 1) queue.add(v);
            }
        }
        return queue.poll();
    }
}
