package leetcode.leetcode0xx.leetcode73;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        if (n == 0) return;
        ;
        boolean firstColumn = false;
        boolean firstRow = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }
        //rows
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    break;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    break;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if (firstColumn) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
