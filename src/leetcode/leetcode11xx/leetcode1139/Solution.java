package leetcode.leetcode11xx.leetcode1139;

public class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] left = new int[m][n], top = new int[m][n];
        int maxD = -1, d;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;
                    top[i][j] = i > 0 ? top[i - 1][j] + 1 : 1;
                    d = Math.min(left[i][j], top[i][j]);
                    while (--d > maxD) {
                        if (left[i - d][j] > d && top[i][j - d] > d) {
                            maxD = d;
                            ans = (d + 1) * (d + 1);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
