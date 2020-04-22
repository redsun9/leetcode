package leetcode.leetcode12xx.leetcode1284;

public class Solution {
    public int minFlips(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int dimension = m * n;
        boolean[][] matrix = new boolean[dimension][dimension];
        boolean[] vector = new boolean[dimension];

        for (int i = 0, pos = 0; i < m; i++)
            for (int j = 0; j < n; j++, pos++) {
                matrix[pos][pos] = true;
                vector[pos] = mat[i][j] == 1;
                if (i > 0) matrix[pos - n][pos] = true;
                if (i < m - 1) matrix[pos + n][pos] = true;
                if (j > 0) matrix[pos - 1][pos] = true;
                if (j < n - 1) matrix[pos + 1][pos] = true;
            }

        //forward
        for (int i = 0; i < dimension - 1; i++) {
            int t = findFirstRow(matrix, i, i);
            if (t == dimension) continue;
            if (i != t) swapRows(matrix, vector, i, t);
            for (int j = i + 1; j < dimension; j++)
                if (matrix[j][i]) divide(matrix, vector, i, j, i, dimension);
        }
        //backward
        for (int i = dimension - 1; i > 0; i--)
            if (matrix[i][i]) {
                for (int j = 0; j < i; j++) if (matrix[j][i]) divide(matrix, vector, i, j, i, i + 1);
            } else if (vector[i]) return -1;

        int ans = 0;
        for (boolean b : vector) if (b) ans++;
        return ans;
    }

    private static int findFirstRow(boolean[][] matrix, int rowStart, int column) {
        int n = matrix.length;
        while (rowStart < n && !matrix[rowStart][column]) rowStart++;
        return rowStart;
    }

    private static void swapRows(boolean[][] matrix, boolean[] vector, int i, int j) {
        boolean[] tRow = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = tRow;
        boolean tBool = vector[i];
        vector[i] = vector[j];
        vector[j] = tBool;
    }

    private static void divide(boolean[][] matrix, boolean[] vector, int i, int j, int from, int to) {
        vector[j] ^= vector[i];
        boolean[] row1 = matrix[i];
        boolean[] row2 = matrix[j];
        for (int k = from; k < to; k++) row2[k] ^= row1[k];
    }
}
