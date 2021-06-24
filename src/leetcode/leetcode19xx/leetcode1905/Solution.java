package leetcode.leetcode19xx.leetcode1905;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static final int[] moves = {1, 0, -1, 0, 1};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int ans = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    grid2[i][j] = 0;
                    queue.add(new int[]{i, j});
                    boolean ok = true;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int i1 = poll[0], j1 = poll[1];
                        if (grid1[i1][j1] != 1) ok = false;
                        for (int k = 0; k < 4; k++) {
                            int i2 = i1 + moves[k];
                            int j2 = j1 + moves[k + 1];
                            if (i2 >= 0 && i2 < m && j2 >= 0 && j2 < n && grid2[i2][j2] == 1) {
                                grid2[i2][j2] = 0;
                                queue.offer(new int[]{i2, j2});
                            }
                        }
                    }
                    if (ok) ans++;
                }
            }
        }
        return ans;
    }
}
