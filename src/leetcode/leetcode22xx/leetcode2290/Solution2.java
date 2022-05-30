package leetcode.leetcode22xx.leetcode2290;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    private static final int[] moves = {-1, 0, 1, 0, -1};

    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0], y = cur[1], step = cur[2];
            for (int i = 0; i < 4; ++i) {
                int nx = x + moves[i], ny = y + moves[i + 1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || dp[nx][ny] != Integer.MAX_VALUE) continue;
                if (grid[nx][ny] == 1) {
                    dp[nx][ny] = step + 1;
                    q.offerLast(new int[]{nx, ny, step + 1});
                } else {
                    dp[nx][ny] = step;
                    q.offerFirst(new int[]{nx, ny, step});
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
