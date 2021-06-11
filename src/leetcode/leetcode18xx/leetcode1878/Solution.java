package leetcode.leetcode18xx.leetcode1878;

import java.util.Arrays;

public class Solution {
    private static void updateMaximum(int[] ans, int val) {
        int pos = ans.length - 1;
        while (pos >= 0 && ans[pos] > val) pos--;
        if (pos >= 0 && ans[pos] != val) {
            for (int i = 0; i < pos; i++) ans[i] = ans[i + 1];
            ans[pos] = val;
        }
    }

    private static int removeDuplicates(int[] arr) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) continue;
            if (count > 0) {
                if (arr[i] != arr[count - 1]) arr[count++] = arr[i];
            } else arr[count++] = arr[i];
        }
        return count;
    }

    private static void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] inc = new int[m + 1][n + 1], dec = new int[m + 1][n + 1];
        int[] tmp = new int[3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                inc[i + 1][j + 1] = inc[i][j] + grid[i][j];
                dec[i + 1][j] = dec[i][j + 1] + grid[i][j];
                updateMaximum(tmp, grid[i][j]);
            }
        }
        for (int i = 1, di = m - 2; i < m - 1; i++, di--) {
            for (int j = 1, dj = n - 2; j < n - 1; j++, dj--) {
                int maxD = Math.min(Math.min(i, j), Math.min(di, dj));
                for (int k = maxD; k > 0; k--) {
                    int val = inc[i + k + 1][j + 1] - inc[i][j - k] +
                            inc[i + 1][j + k + 1] - inc[i - k][j] +
                            dec[i + k + 1][j] - dec[i][j + k + 1] +
                            dec[i + 1][j - k] - dec[i - k][j + 1] -
                            grid[i + k][j] - grid[i - k][j] - grid[i][j - k] - grid[i][j + k];
                    updateMaximum(tmp, val);
                }
            }
        }
        int count = removeDuplicates(tmp);
        int[] ans = Arrays.copyOfRange(tmp, 0, count);
        reverse(ans);
        return ans;
    }
}
