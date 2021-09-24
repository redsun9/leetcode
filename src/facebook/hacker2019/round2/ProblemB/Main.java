package facebook.hacker2019.round2.ProblemB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings("UnnecessarySemicolon")
public class Main {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/facebook/hacker2019/round2/ProblemB/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/facebook/hacker2019/round2/ProblemB/output.txt");
                PrintStream printer = new PrintStream(fos);
        ) {
            int t = Integer.parseInt(scanner.nextLine());
            String[] parts;
            for (int i = 1; i <= t; i++) {
                parts = scanner.nextLine().split(" ");
                int n = Integer.parseInt(parts[0]);
                int m = Integer.parseInt(parts[1]);
                int[][] pairs = new int[m][2];
                for (int j = 0; j < m; j++) {
                    parts = scanner.nextLine().split(" ");
                    pairs[j][0] = Integer.parseInt(parts[0]) - 1;
                    pairs[j][1] = Integer.parseInt(parts[1]) - 1;
                }

                String ans = solve(n, pairs);
                printer.println("Case #" + i + ": " + ans);
            }
        }
    }

    private static String solve(int n, int[][] pairs) {
        int[] d1 = new int[n];
        int[] d2 = new int[n];

        for (int[] pair : pairs) {
            int s = pair[0] + pair[1];
            int d = pair[1] - pair[0];
            if ((s & 1) == 0) d1[s / 2] = Math.max(d1[s / 2], d / 2);
            else d2[s / 2 + 1] = Math.max(d2[s / 2 + 1], d / 2 + 1);
        }

        UnionFind uf = new UnionFind(n);
        for (int i = 1; i < n; i++) {
            for (int d = d1[i], i1 = i - d, i2 = i + d; d > 0; d--, i1++, i2--) {
                uf.union(i1, i2);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int d = d2[i], i1 = i - d, i2 = i + d - 1; d > 0; d--, i1++, i2--) {
                uf.union(i1, i2);
            }
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) count.compute(uf.find(i), (k, v) -> v == null ? 1 : v + 1);

        HashMap<Integer, Boolean> colorMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                Comparator.comparingInt(entry -> -entry.getValue())
        );
        pq.addAll(count.entrySet());

        int balance = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            if (balance > 0) {
                colorMap.put(entry.getKey(), false);
                balance -= entry.getValue();
            } else {
                colorMap.put(entry.getKey(), true);
                balance += entry.getValue();
            }
        }

        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            try {
                ans[i] = colorMap.get(uf.find(i)) ? '1' : '0';
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            }
        }
        return new String(ans);
    }


    @SuppressWarnings({"DuplicatedCode", "SuspiciousNameCombination"})
    private static class UnionFind {
        private final int[] p, rank;

        public UnionFind(int n) {
            rank = new int[n];
            p = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }

        int find(int x) {
            if (x == p[x]) return x;
            else {
                p[x] = find(p[x]);
                return p[x];
            }
        }

        void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return;
            if (rank[x] < rank[y]) p[x] = y;
            else {
                p[y] = x;
                if (rank[x] == rank[y]) ++rank[x];
            }
        }
    }
}
