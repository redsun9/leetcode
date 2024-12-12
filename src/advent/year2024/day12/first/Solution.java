package advent.year2024.day12.first;

import basic.UnionFind;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day12/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day12/first/output.txt");
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
        HashMap<Integer, Integer> perimeter = new HashMap<>();
        for (int i1 = 0; i1 < m; i1++) {
            String s = arr.get(i1);
            for (int j1 = 0; j1 < n; j1++) {
                int key = uf.find(i1 * n + j1);
                space.put(key, space.getOrDefault(key, 0) + 1);
                for (int[] move : moves) {
                    int i2 = i1 + move[0], j2 = j1 + move[1];
                    if (i2 < 0 || i2 >= m || j2 < 0 || j2 >= n || s.charAt(j1) != arr.get(i2).charAt(j2)) {
                        perimeter.put(key, perimeter.getOrDefault(key, 0) + 1);
                    }
                }
            }
        }
        long ans = 0;
        for (Integer key : space.keySet()) ans += (long) space.get(key) * perimeter.get(key);
        return ans;
    }
}
