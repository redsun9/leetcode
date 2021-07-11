package leetcode.leetcode14xx.leetcode1420;

public class Solution2 {
    private static final int p = 1_000_000_007;

    private static int dfs(int n, int m, int k, int i, int max, int[][][] cache) {
        if (n == i) return k == 0 ? 1 : 0;
        if (k < 0) return 0;
        if (cache[max][i][k] == 0) {
            int ans = 0;
            for (int j = 1; j <= max; j++) {
                ans += dfs(n, m, k, i + 1, max, cache);
                if (ans >= p) ans -= p;
            }
            for (int j = max + 1; j <= m; j++) {
                ans += dfs(n, m, k - 1, i + 1, j, cache);
                if (ans >= p) ans -= p;
            }
            cache[max][i][k] = ans + 1;
        }
        return cache[max][i][k] - 1;
    }

    public int numOfArrays(int n, int m, int k) {
        int[][][] cache = new int[m + 1][n + 1][k + 1];
        return dfs(n, m, k, 0, 0, cache);
    }
}
