package leetcode.leetcode9xx.leetcode931;

import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] A) {
        int[] next = Arrays.copyOf(A[0], A[0].length);
        int[] prev = new int[A[0].length];
        int[] tmp;
        int n = next.length;
        for (int i = 1; i < A.length; i++) {
            tmp = prev;
            prev = next;
            next = tmp;
            for (int j = 1; j < n - 1; j++) {
                next[j] = A[i][j] + Math.min(Math.min(prev[j - 1], prev[j]), prev[j + 1]);
            }
            next[0] = A[i][0] + Math.min(prev[0], prev[1]);
            next[n - 1] = A[i][n - 1] + Math.min(prev[n - 1], prev[n - 2]);
        }
        int result = next[0];
        for (int i = 1; i < n; i++) {
            result = Math.min(result, next[i]);
        }
        return result;
    }
}

