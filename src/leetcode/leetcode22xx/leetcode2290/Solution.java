package leetcode.leetcode22xx.leetcode2290;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings({"ConstantConditions", "DuplicatedCode"})
public class Solution {
    private static final int[] moves = {-1, 0, 1, 0, -1};

    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});
        while (true) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], step = cur[2];
            if (x == m - 1 && y == n - 1) return step;
            for (int i = 0; i < 4; ++i) {
                int nx = x + moves[i], ny = y + moves[i + 1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int nstep = step + grid[nx][ny];
                if (dp[nx][ny] > nstep) {
                    dp[nx][ny] = nstep;
                    pq.offer(new int[]{nx, ny, nstep});
                }
            }
        }
    }
}