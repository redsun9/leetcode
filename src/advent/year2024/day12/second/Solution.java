package advent.year2024.day12.second;

import basic.UnionFind;
import basic.tuples.Triple;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Solution {
    private static final int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day12/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day12/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> arr = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank() || s.isEmpty()) continue;
                arr.add(s);
            }

            printer.println(solve(arr));
        }
    }

    private static long solve(List<String> arr) {
        int m = arr.size(), n = arr.get(0).length();
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            String s = arr.get(i);
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (i != m - 1 && arr.get(i + 1).charAt(j) == c) uf.union(i * n + j, i * m + j + n);
                if (j != n - 1 && s.charAt(j + 1) == c) uf.union(i * n + j, i * n + j + 1);
            }
        }

        HashMap<Integer, Integer> space = new HashMap<>();
        HashMap<Integer, Collection<Triple<Integer, Integer, Integer>>> fences = new HashMap<>();
        for (int i1 = 0; i1 < m; i1++) {
            String s = arr.get(i1);
            for (int j1 = 0; j1 < n; j1++) {
                int key = uf.find(i1 * n + j1);
                space.put(key, space.getOrDefault(key, 0) + 1);
                for (int k = 0; k < moves.length; k++) {
                    int i2 = i1 + moves[k][0], j2 = j1 + moves[k][1];
                    if (i2 < 0 || i2 >= m || j2 < 0 || j2 >= n || s.charAt(j1) != arr.get(i2).charAt(j2)) {
                        fences.computeIfAbsent(key, x -> new ArrayList<>()).add(new Triple<>(i1, j1, k));
                    }
                }
            }
        }
        long ans = 0;
        for (Integer key : space.keySet()) ans += (long) space.get(key) * numberOfEdges(fences.get(key));
        return ans;
    }

    private static int numberOfEdges(Collection<Triple<Integer, Integer, Integer>> set) {
        UnionFind uf = new UnionFind(set.size());
        Map<Triple<Integer, Integer, Integer>, Integer> map = new HashMap<>();
        for (Triple<Integer, Integer, Integer> triple : set) map.put(triple, map.size());

        for (Map.Entry<Triple<Integer, Integer, Integer>, Integer> entry : map.entrySet()) {
            Triple<Integer, Integer, Integer> triple = entry.getKey();
            Integer u = entry.getValue();
            Triple<Integer, Integer, Integer> triple1 = new Triple<>(triple.getA() + moves[triple.getC()][1], triple.getB() + moves[triple.getC()][0], triple.getC());
            Triple<Integer, Integer, Integer> triple2 = new Triple<>(triple.getA() - moves[triple.getC()][1], triple.getB() - moves[triple.getC()][0], triple.getC());

            if (map.containsKey(triple1)) uf.union(u, map.get(triple1));
            if (map.containsKey(triple2)) uf.union(u, map.get(triple2));
        }

        Set<Integer> xSet = new HashSet<>();
        for (int i = 0; i < set.size(); i++) xSet.add(uf.find(i));
        return xSet.size();
    }
}
