package leetcode.leetcode8xx.leetcode807;

public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] fromI = new int[m];
        int[] fromJ = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                fromI[i] = Math.max(fromI[i], grid[i][j]);
                fromJ[j] = Math.max(fromJ[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += Math.min(fromI[i], fromJ[j]) - grid[i][j];
            }
        }
        return ans;
    }
}
