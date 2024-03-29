package leetcode.leetcode30xx.leetcode3033;

import java.util.Arrays;

public class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] max = new int[n];
        Arrays.fill(max, -1);
        for (int[] row : matrix) for (int j = 0; j < n; j++) max[j] = Math.max(max[j], row[j]);
        for (int[] row : matrix) for (int j = 0; j < n; j++) if (row[j] == -1) row[j] = max[j];
        return matrix;
    }
}
