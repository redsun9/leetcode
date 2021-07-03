package leetcode.leetcode17xx.leetcode1727;

import java.util.Arrays;

public class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix[0].length;
        int ans = 0;
        int[] h = new int[n];
        int[] tmp = new int[n];
        for (int[] row : matrix) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 0) h[j] = 0;
                else h[j]++;
            }
            System.arraycopy(h, 0, tmp, 0, n);
            Arrays.sort(tmp);
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, tmp[j] * (n - j));
            }
        }
        return ans;
    }
}
