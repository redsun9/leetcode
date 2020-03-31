package leetcode.leetcode0xx.leetcode59;

public class Solution {
    public int[][] generateMatrix(int n) {
        int total = n * n;
        if (total == 1) return new int[][]{{1}};
        int[][] ans = new int[n][n];
        int i = 0, j = 0;
        ans[0][0] = 1;
        int count = 1;
        int rb = n - 1;
        int lb = 0;
        int tb = 1;
        int bb = n - 1;


        while (true) {
            while (j < rb) {
                j++;
                ans[i][j] = ++count;
                if (count == total) return ans;
            }
            rb--;
            while (i < bb) {
                i++;
                ans[i][j] = ++count;
                if (count == total) return ans;
            }
            bb--;
            while (j > lb) {
                j--;
                ans[i][j] = ++count;
                if (count == total) return ans;
            }
            lb++;
            while (i > tb) {
                i--;
                ans[i][j] = ++count;
                if (count == total) return ans;
            }
            tb++;
        }
    }
}
