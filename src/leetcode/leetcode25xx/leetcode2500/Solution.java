package leetcode.leetcode25xx.leetcode2500;

import java.util.Arrays;

public class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int[] row : grid) Arrays.sort(row);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int[] row : grid) max = Math.max(max, row[i]);
            ans += max;
        }
        return ans;
    }
}
