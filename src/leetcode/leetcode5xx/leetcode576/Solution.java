package leetcode.leetcode5xx.leetcode576;

import java.util.Arrays;

@SuppressWarnings("SpellCheckingInspection")
public class Solution {
    public static final int p = 1_000_000_007;

    private static int f(int m, int n, int k, int i, int j, int[][][] cache) {
        if (i < 0 || i == m || j < 0 || j == n) return 1;
        if (k == 0) return 0;
        if (cache[i][j][k - 1] == -1) {
            cache[i][j][k - 1] = (int) ((
                    (long) f(m, n, k - 1, i - 1, j, cache) +
                            f(m, n, k - 1, i + 1, j, cache) +
                            f(m, n, k - 1, i, j - 1, cache) +
                            f(m, n, k - 1, i, j + 1, cache)) % p);
        }
        return cache[i][j][k - 1];
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int minD = Math.min(
                Math.min(startRow + 1, m - startRow),
                Math.min(startColumn + 1, n - startColumn)
        );
        if (minD > maxMove) return 0;

        int[][][] cache = new int[m][n][maxMove];
        for (int[][] arrs : cache) {
            for (int[] arr : arrs) {
                Arrays.fill(arr, -1);
            }
        }
        return f(m, n, maxMove, startRow, startColumn, cache);
    }
}
