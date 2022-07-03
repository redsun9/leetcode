package leetcode.leetcode23xx.leetcode2328;

import java.util.ArrayDeque;
import java.util.Queue;

//// O(m*n) - space, O(m*n) - time
public class Solution2 {
    private static final int p = 1_000_000_007;
    private static final int[] moves = {1, 0, -1, 0, 1};

    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] inOrder = new int[m][n];
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            int[] row = grid[i];
            int[] depRow = inOrder[i];
            int[] prev = i > 0 ? grid[i - 1] : null;
            int[] next = i + 1 < m ? grid[i + 1] : null;
            for (int j = 0; j < n; j++) {
                int val = row[j];
                int dep = 0;

                if (prev != null && val > prev[j]) dep++;
                if (next != null && val > next[j]) dep++;
                if (j - 1 >= 0 && val > row[j - 1]) dep++;
                if (j + 1 <= n - 1 && val > row[j + 1]) dep++;

                if (dep == 0) queue.add(new int[]{i, j});
                else depRow[j] = dep;
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i1 = poll[0], j1 = poll[1], val = grid[i1][j1];
            int sum = 1;

            for (int k = 0; k < 4; k++) {
                int i2 = i1 + moves[k], j2 = j1 + moves[k + 1];
                if (i2 < 0 || j2 < 0 || i2 >= m || j2 >= n || grid[i2][j2] == val) continue;
                if (grid[i2][j2] < val) {
                    sum += dp[i2][j2];
                    if (sum >= p) sum -= p;
                } else if (--inOrder[i2][j2] == 0) queue.add(new int[]{i2, j2});
            }
            dp[i1][j1] = sum;
            ans += sum;
            if (ans >= p) ans -= p;
        }
        return ans;
    }
}
