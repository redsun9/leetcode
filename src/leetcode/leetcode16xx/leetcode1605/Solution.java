package leetcode.leetcode16xx.leetcode1605;

// O(m+n) time if not count memory allocation
public class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] ans = new int[m][n];
        int i = 0, j = 0;
        while (i < m && j < n) {
            int a = Math.min(rowSum[i], colSum[j]);
            ans[i][j] = a;
            if ((rowSum[i] -= a) == 0) i++;
            if ((colSum[j] -= a) == 0) j++;
        }
        return ans;
    }
}