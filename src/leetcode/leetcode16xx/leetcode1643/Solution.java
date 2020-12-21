package leetcode.leetcode16xx.leetcode1643;

public class Solution {
    // f(h,w) = binomial(h,h+w)
    public String kthSmallestPath(int[] destination, int k) {
        int m = destination[0];
        int n = destination[1];
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m || j == n) dp[i][j] = 1;
                else dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        StringBuilder sb = new StringBuilder(m + n);
        int h = 0, w = 0;
        while (h != m && w != n) {
            if (dp[h][w + 1] >= k) {
                sb.append('H');
                w++;
            } else {
                sb.append('V');
                k -= dp[h][w + 1];
                h++;
            }
        }
        while (++h <= m) sb.append('V');
        while (++w <= n) sb.append('H');
        return sb.toString();
    }
}
