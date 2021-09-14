package leetcode.leetcode18xx.leetcode1895;

public class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rowPref = new int[m][n + 1];
        int[][] colPref = new int[m + 1][n];
        int[][] mDiagPref = new int[m + 1][n + 1];
        int[][] rDiagPref = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPref[i][j + 1] = rowPref[i][j] + grid[i][j];
                colPref[i + 1][j] = colPref[i][j] + grid[i][j];
                mDiagPref[i + 1][j + 1] = mDiagPref[i][j] + grid[i][j];
                rDiagPref[i + 1][j] = rDiagPref[i][j + 1] + grid[i][j];
            }
        }

        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i1 = m - 1, i2 = m - k; i2 >= 0; i1--, i2--) {
                for (int j1 = n - 1, j2 = n - k; j2 >= 0; j1--, j2--) {
                    int sum = mDiagPref[i1 + 1][j1 + 1] - mDiagPref[i2][j2];
                    boolean ok = sum == rDiagPref[i1 + 1][j2] - rDiagPref[i2][j1 + 1];
                    for (int ic = i2; ic <= i1 && ok; ic++) ok = sum == rowPref[ic][j1 + 1] - rowPref[ic][j2];
                    for (int jc = j2; jc <= j1 && ok; jc++) ok = sum == colPref[i1 + 1][jc] - colPref[i2][jc];
                    if (ok) return k;
                }
            }
        }
        return 1;
    }
}
