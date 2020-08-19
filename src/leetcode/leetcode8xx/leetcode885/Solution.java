package leetcode.leetcode8xx.leetcode885;

public class Solution {
    private static final int[] moves = {0, 1, 0, -1, 0};

    public int[][] spiralMatrixIII(int r, int c, int r0, int c0) {
        int n = r * c;
        int[][] ans = new int[n][2];

        for (int i = 0, mode = 0; i < n; mode++) {
            for (int k = 0; k < mode / 2 + 1; k++) {
                if (r0 >= 0 && r0 < r && c0 >= 0 && c0 < c) {
                    ans[i][0] = r0;
                    ans[i][1] = c0;
                    i++;
                }
                r0 += moves[mode & 3];
                c0 += moves[(mode & 3) + 1];
            }
        }
        return ans;
    }
}
