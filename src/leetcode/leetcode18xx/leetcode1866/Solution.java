package leetcode.leetcode18xx.leetcode1866;

public class Solution {
    public static final int p = 1_000_000_007;

    private static int dfs(int n, int k, int[][] cache) {
        if (n == k) return 1;
        if (k == 0) return 0;
        if (cache[n][k] == 0) {
            cache[n][k] = (int) ((dfs(n - 1, k - 1, cache) + dfs(n - 1, k, cache) * (n - 1L)) % p) + 1;
        }
        return cache[n][k] - 1;
    }

    public int rearrangeSticks(int n, int k) {
        if (k > n) return 0;
        if (n == k) return 1;
        if (k == 0) return 0;
        int[][] cache = new int[n + 1][k + 1];
        return dfs(n, k, cache);
    }
}
