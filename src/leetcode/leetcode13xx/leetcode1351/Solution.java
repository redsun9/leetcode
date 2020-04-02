package leetcode.leetcode13xx.leetcode1351;

public class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        int i = 0;
        int m = grid.length;
        int n = grid[0].length;
        int j = n - 1;
        while (i < m) {
            int[] row = grid[i];
            while (j >= 0 && row[j] < 0) j--;
            if (j < 0) break;
            ans += (n - j - 1);
            i++;
        }
        ans += (m - i) * n;
        return ans;
    }
}
