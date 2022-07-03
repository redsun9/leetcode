package leetcode.leetcode23xx.leetcode2328;

import java.util.Arrays;
import java.util.Comparator;

// O(m*n) - space, O(m*n*log(m*n)) - time
public class Solution {
    private static final int p = 1_000_000_007;

    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] order = new int[m * n][3];
        for (int i = 0, pos = 0; i < m; i++) {
            for (int j = 0; j < n; j++, pos++) {
                order[pos][0] = grid[i][j];
                order[pos][1] = i;
                order[pos][2] = j;
            }
        }
        Arrays.sort(order, Comparator.comparingInt(x -> x[0]));
        int[][] dp = new int[m][n];
        for (int[] node : order) {
            int val = node[0], i = node[1], j = node[2];
            int sum = 1;
            if (i - 1 >= 0 && val > grid[i - 1][j]) {
                sum += dp[i - 1][j];
                if (sum >= p) sum -= p;
            }
            if (i + 1 <= m - 1 && val > grid[i + 1][j]) {
                sum += dp[i + 1][j];
                if (sum >= p) sum -= p;
            }
            if (j - 1 >= 0 && val > grid[i][j - 1]) {
                sum += dp[i][j - 1];
                if (sum >= p) sum -= p;
            }
            if (j + 1 <= n - 1 && val > grid[i][j + 1]) {
                sum += dp[i][j + 1];
                if (sum >= p) sum -= p;
            }
            dp[i][j] = sum;
        }

        int ans = 0;
        for (int[] row : dp) {
            for (int val : row) {
                ans += val;
                if (ans >= p) ans -= p;
            }
        }
        return ans;
    }
}
