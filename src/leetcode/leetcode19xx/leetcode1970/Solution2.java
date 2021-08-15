package leetcode.leetcode19xx.leetcode1970;

// Union find
// O(n) - space, O(n) - time

public class Solution2 {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public int latestDayToCross(int row, int col, int[][] cells) {
        if (row == 1) return col - 1;
        if (col == 1) return 0;
        UnionFind uf = new UnionFind(row * col);
        boolean[][] mat = new boolean[row][col];
        for (int firstRowElem = 0, i = firstRowElem + 1, lastRowElem = col * (row - 1), j = lastRowElem + 1; i < col; i++, j++) {
            uf.union(firstRowElem, i);
            uf.union(lastRowElem, j);
        }
        int ans = row * col - 1, cellStart = 0, cellEnd = (row - 1) * col;
        while (true) {
            int x = cells[ans][0] - 1, y = cells[ans][1] - 1, key = col * x + y;
            mat[x][y] = true;
            for (int k = 0; k < 4; k++) {
                int x1 = x + moves[k], y1 = y + moves[k + 1], key1 = col * x1 + y1;
                if (x1 >= 0 && x1 < row && y1 >= 0 && y1 < col && mat[x1][y1]) uf.union(key, key1);
            }
            if (uf.find(cellStart) == uf.find(cellEnd)) return ans;
            ans--;
        }
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
