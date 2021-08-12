package leetcode.leetcode4xx.leetcode498;

public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        if (m == 1) return mat[0];

        int[] ans = new int[m * n];
        int pos = 0;
        for (int d = 0; d <= m + n - 2; d++) {
            int dx = (d & 1) == 0 ? -1 : 1;
            int leftX = Math.min(d, m - 1), rightX = Math.max(0, d + 1 - n);
            int startX = (d & 1) == 0 ? leftX : rightX;
            int endX = (d & 1) == 0 ? rightX - 1 : leftX + 1;
            for (int i = startX, j = d - startX; i != endX; i += dx, j -= dx) ans[pos++] = mat[i][j];
        }
        return ans;
    }
}
