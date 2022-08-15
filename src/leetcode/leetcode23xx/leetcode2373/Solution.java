package leetcode.leetcode23xx.leetcode2373;

public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - 2][n - 2];
        for (int i = 2; i < m; i++) {
            for (int j = 2; j < n; j++) {
                int max = Integer.MIN_VALUE;
                for (int di = 0; di < 3; di++) {
                    for (int dj = 0; dj < 3; dj++) {
                        max = Math.max(max, grid[i - di][j - dj]);
                    }
                }
                ans[i - 2][j - 2] = max;
            }
        }
        return ans;
    }
}
