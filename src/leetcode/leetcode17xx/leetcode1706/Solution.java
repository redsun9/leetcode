package leetcode.leetcode17xx.leetcode1706;

import java.util.Arrays;

public class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] prev = new int[n], next = new int[n], tmp;
        for (int i = 0; i < n; i++) prev[i] = i;

        for (int[] row : grid) {
            Arrays.fill(next, -1);
            for (int i = 0; i < n; i++) {
                if (prev[i] == -1) continue;
                if (row[i] == 1 && i != n - 1 && row[i + 1] == 1) next[i + 1] = prev[i];
                if (row[i] == -1 && i != 0 && row[i - 1] == -1) next[i - 1] = prev[i];
            }
            tmp = prev;
            prev = next;
            next = tmp;
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            if (prev[i] != -1) ans[prev[i]] = i;
        }
        return ans;
    }
}
