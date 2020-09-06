package leetcode.leetcode15xx.leetcode1572;

public class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int ans = 0;
        for (int i = 0, j = n - 1; i < n; i++, j--) ans += mat[i][i] + mat[i][j];
        if (n % 2 == 1) ans -= mat[n / 2][n / 2];
        return ans;
    }
}
