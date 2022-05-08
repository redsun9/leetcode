package leetcode.leetcode22xx.leetcode2267;

public class Solution {
    private static final int[] failed = {Integer.MAX_VALUE, Integer.MIN_VALUE};

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (((m + n) & 1) == 0) return false;
        if (grid[0][0] == ')') return false;

        int[][][] dp = new int[m][n][2];
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;

        for (int j = 1; j < n; j++) dp[0][j] = f(dp[0][j - 1], grid[0][j]);
        for (int i = 1; i < m; i++) dp[i][0] = f(dp[i - 1][0], grid[i][0]);

        for (int i = 1; i < m; i++) for (int j = 1; j < n; j++) dp[i][j] = f(dp[i - 1][j], dp[i][j - 1], grid[i][j]);
        return dp[m - 1][n - 1][0] == 0;
    }

    private static int[] f(int[] a, int[] b, char c) {
        if (a == failed) return f(b, c);
        if (b == failed) return f(a, c);
        int min = Math.min(a[0], b[0]), max = Math.max(a[1], b[1]);
        if (c == '(') return new int[]{min + 1, max + 1};
        if (max == 0) return failed;
        if (min == 0) return new int[]{1, max - 1};
        return new int[]{min - 1, max - 1};
    }

    private static int[] f(int[] a, char c) {
        if (a == failed || a[0] == 0 && c == ')') return failed;
        int d = c == '(' ? 1 : -1;
        return new int[]{a[0] + d, a[1] + d};
    }
}
