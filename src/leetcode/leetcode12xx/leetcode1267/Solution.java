package leetcode.leetcode12xx.leetcode1267;

public class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] w = new int[m], h = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    w[i]++;
                    h[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (w[i] > 1 || h[j] > 1)) ans++;
            }
        }
        return ans;
    }
}
