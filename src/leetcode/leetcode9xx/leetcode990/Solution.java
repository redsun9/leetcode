package leetcode.leetcode9xx.leetcode990;

public class Solution {
    private static final int n = 26;

    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(n);
        for (String s : equations) {
            if (s.charAt(1) == '=') uf.union(s.charAt(0) - 'a', s.charAt(3) - 'a');
        }
        for (String s : equations) {
            if (s.charAt(1) == '!' && uf.find(s.charAt(0) - 'a') == uf.find(s.charAt(3) - 'a'))
                return false;
        }
        return true;
    }

    @SuppressWarnings({"DuplicatedCode", "SuspiciousNameCombination"})
    private static class UnionFind {
        private final int[] p, rank;

        public UnionFind(int n) {
            rank = new int[n];
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
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
            if (rank[x] < rank[y])
                p[x] = y;
            else {
                p[y] = x;
                if (rank[x] == rank[y])
                    ++rank[x];
            }
        }
    }
}
