package leetcode.leetcode24xx.leetcode2482;

public class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m; i++) {
            int[] gridRow = grid[i];
            for (int j = 0; j < n; j++) {
                if (gridRow[j] == 0) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int defaultValue = m + n;
        for (int i = 0; i < m; i++) {
            int[] gridRow = grid[i];
            int rowVal = defaultValue - 2 * rows[i];
            for (int j = 0; j < n; j++) gridRow[j] = rowVal - 2 * cols[j];
        }
        return grid;
    }
}
