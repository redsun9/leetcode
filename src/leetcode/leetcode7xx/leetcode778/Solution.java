package leetcode.leetcode7xx.leetcode778;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static final int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int[] a : dp) Arrays.fill(a, Integer.MAX_VALUE);
        dp[0][0] = grid[0][0];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            int curVal = dp[i][j];
            for (int[] move : moves) {
                int newI = i + move[0];
                int newJ = j + move[1];
                if (newI >= 0 && newI < n && newJ >= 0 && newJ < n) {
                    int tmpVal = Math.max(curVal, grid[newI][newJ]);
                    if (tmpVal < dp[newI][newJ]) {
                        dp[newI][newJ] = tmpVal;
                        queue.add(new int[]{newI, newJ});
                    }
                }
            }
        }
        return dp[n - 1][n - 1];
    }
}
