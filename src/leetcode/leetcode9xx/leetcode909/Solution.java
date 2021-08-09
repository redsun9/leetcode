package leetcode.leetcode9xx.leetcode909;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length, s = n * n;
        if (n <= 2) return n - 1;
        int[] dp = new int[s];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int val = dp[node];
            for (int d = 1, j = node + d; d <= 6 && j < s; d++, j++) {
                int to = board[n - 1 - j / n][((j / n) & 1) == 0 ? j % n : n - 1 - j % n];
                if (to == -1) {
                    if (dp[j] == -1) {
                        dp[j] = val + 1;
                        queue.add(j);
                    }
                } else {
                    if (dp[to - 1] == -1) {
                        dp[to - 1] = val + 1;
                        queue.add(to - 1);
                    }
                }
            }
        }
        return dp[s - 1] == -1 ? -1 : dp[s - 1];
    }
}
