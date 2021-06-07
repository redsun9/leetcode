package leetcode.leetcode18xx.leetcode1886;

public class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean ok = true;
        for (int i = 0; i < n && ok; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    ok = false;
                    break;
                }
            }
        }
        if (ok) return true;

        ok = true;
        for (int i1 = 0, i2 = n - 1; i1 < n && ok; i1++, i2--) {
            for (int j1 = 0, j2 = n - 1; j1 < n; j1++, j2--) {
                if (mat[i1][j1] != target[i2][j2]) {
                    ok = false;
                    break;
                }
            }
        }
        if (ok) return true;

        ok = true;
        for (int i1 = 0, j2 = n - 1; i1 < n && ok; i1++, j2--) {
            for (int j1 = 0, i2 = 0; j1 < n; j1++, i2++) {
                if (mat[i1][j1] != target[i2][j2]) {
                    ok = false;
                    break;
                }
            }
        }
        if (ok) return true;

        for (int i1 = 0, j2 = 0; i1 < n; i1++, j2++) {
            for (int j1 = 0, i2 = n - 1; j1 < n; j1++, i2--) {
                if (mat[i1][j1] != target[i2][j2]) {
                    return false;
                }
            }
        }
        return true;
    }
}
