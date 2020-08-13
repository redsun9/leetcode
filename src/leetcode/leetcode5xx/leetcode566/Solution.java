package leetcode.leetcode5xx.leetcode566;

public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c || m == r && n == c) return nums;
        int[][] ans = new int[r][c];
        for (int i1 = 0, i2 = 0, j2 = 0; i1 < m; i1++) {
            for (int j1 = 0; j1 < n; j1++) {
                ans[i2][j2] = nums[i1][j1];
                if (++j2 == c) {
                    i2++;
                    j2 = 0;
                }
            }
        }
        return ans;
    }
}
