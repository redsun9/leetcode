package leetcode.leetcode13xx.leetcode1368;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class Solution {
    private static final int[][] signs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int target = (m - 1) << 10 | (n - 1);
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int d = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        HashSet<Integer> toMoveFrom = new HashSet<>();
        while (true) {
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                int i = poll >> 10;
                int j = poll & 1023;
                if (dp[i][j] > d) {
                    dp[i][j] = d;
                    toMoveFrom.add(poll);
                    int[] move = signs[grid[i][j] - 1];
                    int i1 = i + move[0];
                    int j1 = j + move[1];
                    if (i1 >= 0 && j1 >= 0 && i1 < m && j1 < n) {
                        queue.add(i1 << 10 | j1);
                    }
                }
                if (poll == target) return dp[i][j];
            }
            for (Integer poll : toMoveFrom) {
                int i = poll >> 10;
                int j = poll & 1023;
                for (int[] move : signs) {
                    int i1 = i + move[0];
                    int j1 = j + move[1];
                    if (i1 >= 0 && j1 >= 0 && i1 < m && j1 < n) {
                        queue.add(i1 << 10 | j1);
                    }
                }
            }
            d++;
            toMoveFrom.clear();
        }
    }
}
