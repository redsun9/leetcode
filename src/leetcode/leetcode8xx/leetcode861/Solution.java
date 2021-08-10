package leetcode.leetcode8xx.leetcode861;

public class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 || n == 1) return m * ((1 << n) - 1);
        int ans = m << (n - 1);
        for (int j = 1, shift = n - 2; j < n; j++, shift--) {
            int sum = 0;
            for (int[] row : grid) sum += row[0] ^ row[j];
            ans += Math.max(sum, m - sum) << shift;
        }
        return ans;
    }
}
