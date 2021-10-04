package leetcode.leetcode3xx.leetcode305;

import java.util.*;

@SuppressWarnings({"DuplicatedCode", "SuspiciousNameCombination"})
public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        if (operators == null || operators.length == 0) return Collections.emptyList();
        int k = operators.length;
        UnionFind uf = new UnionFind(k);
        HashMap<Pair, Integer> map = new HashMap<>();

        int curr = 0;
        List<Integer> ans = new ArrayList<>(k);
        for (int u = 0; u < k; u++) {
            int x = operators[u].x, y = operators[u].y;
            Integer previousVal = map.putIfAbsent(new Pair(x, y), u);
            if (previousVal == null) {
                curr++;
                for (int j = 0; j < 4; j++) {
                    int x1 = x + moves[j], y1 = y + moves[j + 1];
                    Integer v = map.get(new Pair(x1, y1));
                    if (v == null || uf.find(v) == uf.find(u)) continue;
                    uf.union(u, v);
                    curr--;
                }
            }
            ans.add(curr);
        }
        return ans;
    }

    private static class Pair {
        final int x, y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


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
