package leetcode.leetcode6xx.leetcode664;

//top-bottom
public class Solution2 {
    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[][] dp = new int[n][n];
        return dfs(s, 0, n - 1, dp);
    }

    private static int dfs(String s, int i, int j, int[][] dp) {
        if (i == j) return 1;
        if (i == j + 1) return s.charAt(i) == s.charAt(j) ? 1 : 2;
        if (dp[i][j] != 0) return dp[i][j];
        int min = j - i + 1;
        for (int k = i; k < j; k++) {
            min = Math.min(min, dfs(s, i, k, dp) + dfs(s, k + 1, j, dp) + (s.charAt(k) == s.charAt(j) ? -1 : 0));
        }
        dp[i][j] = min;
        return min;
    }
}
