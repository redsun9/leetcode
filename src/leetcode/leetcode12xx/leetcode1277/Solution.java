package leetcode.leetcode12xx.leetcode1277;

public class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[] c = new int[n];
        int[] diag = new int[n];
        for (int[] row : matrix) {
            int r = 0;
            int prevD = 0;
            for (int i = 0; i < n; i++) {
                if (row[i] == 1) {
                    int maxD = min(r, c[i], prevD) + 1;
                    ans += maxD;
                    prevD = diag[i];
                    diag[i] = maxD;
                    c[i]++;
                    r++;
                } else {
                    r = 0;
                    prevD = diag[i];
                    diag[i] = 0;
                    c[i] = 0;
                }
            }
        }
        return ans;
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
