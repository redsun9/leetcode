package leetcode.leetcode16xx.leetcode1631;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static final int[] moves = {1, 0, -1, 0, 1};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        pq.offer(new int[]{0, 0, 0});
        while (true) {
            int[] poll = pq.poll();
            int prevVal = poll[0], prevX = poll[1], prevY = poll[2];
            if (prevVal != dp[prevX][prevY]) continue;
            if (prevX == m - 1 && prevY == n - 1) return prevVal;
            for (int i = 0; i < 4; i++) {
                int newX = prevX + moves[i], newY = prevY + moves[i + 1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newVal = Math.max(prevVal, Math.abs(heights[prevX][prevY] - heights[newX][newY]));
                    if (dp[newX][newY] > newVal) {
                        dp[newX][newY] = newVal;
                        pq.offer(new int[]{newVal, newX, newY});
                    }
                }
            }
        }
    }
}
