package leetcode.leetcode8xx.leetcode835;

public class Solution {
    public int largestOverlap(int[][] a, int[][] b) {
        int n = a.length;
        int ans = 0;
        int[] rowsA = new int[n];
        int[] rowsB = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowsA[i] |= a[i][j] << j;
                rowsB[i] |= b[i][j] << j;
            }
        }
        for (int h = -n + 1; h <= n - 1; h++) {
            for (int w = -n + 1; w <= n - 1; w++) {
                int tmp = 0;
                for (int i1 = Math.max(0, -h), i2 = i1 + h; i1 < n - Math.max(0, h); i1++, i2++) {
                    int rowShifted = w >= 0 ? rowsA[i1] >>> w : rowsA[i1] << -w;
                    tmp += Integer.bitCount(rowShifted & rowsB[i2]);
                }
                ans = Math.max(ans, tmp);
            }
        }
        return ans;
    }
}
