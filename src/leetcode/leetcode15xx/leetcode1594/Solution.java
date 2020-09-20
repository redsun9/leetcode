package leetcode.leetcode15xx.leetcode1594;

public class Solution {
    public static final int p = 1_000_000_007;

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean zeroExists = false;
        long[][] neg = new long[m + 1][n + 1], pos = new long[m + 1][n + 1];
        pos[0][1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) zeroExists = true;
                else if (grid[i][j] > 0) {
                    pos[i + 1][j + 1] = Math.max(pos[i + 1][j], pos[i][j + 1]);
                    neg[i + 1][j + 1] = Math.min(neg[i + 1][j], neg[i][j + 1]);
                } else {
                    pos[i + 1][j + 1] = Math.min(neg[i + 1][j], neg[i][j + 1]);
                    neg[i + 1][j + 1] = Math.max(pos[i + 1][j], pos[i][j + 1]);
                }
                pos[i + 1][j + 1] *= grid[i][j];
                neg[i + 1][j + 1] *= grid[i][j];
            }
        }
        return pos[m][n] != 0 ? (int) (pos[m][n] % p) : zeroExists ? 0 : -1;
    }
}
