package leetcode.leetcode29xx.leetcode2946;

public class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        k %= n;
        if (k == 0) return true;

        for (int[] row : mat) {
            for (int i = 0, j = k; i < n; ) {
                if (row[i++] != row[j++]) return false;
                if (j == n) j = 0;
            }
        }
        return true;
    }
}
