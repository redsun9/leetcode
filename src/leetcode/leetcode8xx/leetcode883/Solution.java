package leetcode.leetcode8xx.leetcode883;

public class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int xz = 0, yz = 0;
            int[] row = grid[i];
            for (int j = 0; j < n; j++) {
                if (row[j] != 0) ans++;
                xz = Math.max(xz, row[j]);
                yz = Math.max(yz, grid[j][i]);
            }
            ans += xz + yz;
        }
        return ans;
    }
}
