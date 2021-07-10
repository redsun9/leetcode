package leetcode.leetcode19xx.leetcode1926;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static final int[] moves = {1, 0, -1, 0, 1};

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{entrance[0], entrance[1], 0});

        int x1, y1, d, x2, y2;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            x1 = poll[0];
            y1 = poll[1];
            d = poll[2];
            for (int k = 0; k < 4; k++) {
                x2 = x1 + moves[k];
                y2 = y1 + moves[k + 1];
                if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n && maze[x2][y2] == '.' && !visited[x2][y2]) {
                    if (x2 == 0 || x2 == m - 1 || y2 == 0 || y2 == n - 1) return d + 1;
                    visited[x2][y2] = true;
                    queue.add(new int[]{x2, y2, d + 1});
                }
            }
        }
        return -1;
    }
}
