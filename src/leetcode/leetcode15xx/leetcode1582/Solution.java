package leetcode.leetcode15xx.leetcode1582;

public class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] h = new int[m];
        int[] w = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                h[i] += mat[i][j];
                w[j] += mat[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (h[i] != 1) continue;
            int j = 0;
            while (j < n && mat[i][j] == 0) j++;
            if (j != n && w[j] == 1) ans++;
        }
        return ans;
    }
}
