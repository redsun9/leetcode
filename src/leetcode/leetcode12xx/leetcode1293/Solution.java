package leetcode.leetcode12xx.leetcode1293;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    private static final int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 || n == 1) {
            int c = 0;
            if (m == 1) {
                for (int a : grid[0]) c += a;
                return c <= k ? n - 1 : -1;
            } else {
                for (int[] ints : grid) c += ints[0];
                return c <= k ? m - 1 : -1;
            }
        } else {
            k = Math.min(k, m + n - 3);
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dp[i], m * n);
            }
            dp[0][0] = 0;
            Queue<int[]> prev = new ArrayDeque<>();
            Queue<int[]> next = new ArrayDeque<>();
            prev.add(new int[]{0, 0});
            while (!prev.isEmpty() && k >= 0) {
                while (!prev.isEmpty()) {
                    int[] cell = prev.poll();
                    for (int[] move : moves) {
                        int i = cell[0] + move[0];
                        int j = cell[1] + move[1];
                        if (i >= 0 && j >= 0 && i < m && j < n && dp[cell[0]][cell[1]] + 1 < dp[i][j]) {
                            dp[i][j] = dp[cell[0]][cell[1]] + 1;
                            if (grid[i][j] == 0) {
                                prev.add(new int[]{i, j});
                            } else {
                                next.add(new int[]{i, j});
                            }
                        }
                    }
                }
                k--;
                Queue<int[]> tmp = prev;
                prev = next;
                next = tmp;
            }
            return dp[m - 1][n - 1] < m * n ? dp[m - 1][n - 1] : -1;
        }
    }
}
