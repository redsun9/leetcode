package leetcode.leetcode23xx.leetcode2397;

public class Solution {
    public int maximumRows(int[][] mat, int cols) {
        int m = mat.length, n = mat[0].length;
        if (n == cols) return m;

        int[] rowMaks = new int[m];
        for (int i = 0; i < m; i++) {
            int[] row = mat[i];
            int mask = 0;
            for (int j = 0; j < n; j++) mask |= row[j] << j;
            rowMaks[i] = mask;
        }
        return dfs(0, n, cols, 0, rowMaks);
    }

    private static int dfs(int i, int n, int cols, int mask, int[] rowMasks) {
        if (cols == 0) {
            int ans = 0;
            for (int rowMask : rowMasks) if ((rowMask & mask) == rowMask) ans++;
            return ans;
        } else if (n - i < cols) {
            return 0;
        } else return Math.max(
                dfs(i + 1, n, cols - 1, mask | 1 << i, rowMasks),
                dfs(i + 1, n, cols, mask, rowMasks)
        );
    }
}
