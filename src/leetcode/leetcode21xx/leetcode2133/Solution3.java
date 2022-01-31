package leetcode.leetcode21xx.leetcode2133;

// Space complexity - O(1), time complexity - O(n^2)

public class Solution3 {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int[] row : matrix) {
            for (int num : row) {
                int abs = Math.abs(num);
                if (row[abs - 1] < 0) return false;
                row[abs - 1] = -row[abs - 1];
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                int abs = Math.abs(matrix[i][j]);
                if (matrix[abs - 1][j] > 0) return false;
                matrix[abs - 1][j] = -matrix[abs - 1][j];
            }
        }
        return true;
    }
}
