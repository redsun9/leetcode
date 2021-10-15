package leetcode.leetcode5xx.leetcode505;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    /**
     * @param maze:        the maze
     * @param start:       the start
     * @param destination: the destination
     * @return the shortest distance for the ball to stop at the destination
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][][] dist = new int[2][m][n];
        boolean[] canStop = new boolean[2];

        dist[0][start[0]][start[1]] = 1;
        dist[1][start[0]][start[1]] = 1;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[3]));
        for (int i = 0; i < 4; i++) queue.offer(new int[]{start[0], start[1], i, 1});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            int k = poll[2];
            int d = dist[k & 1][x1][y1];
            if (d != poll[3]) continue;

            int x2 = x1 + moves[k];
            int y2 = y1 + moves[k + 1];
            if (x2 >= 0 && y2 >= 0 && x2 < m && y2 < n && maze[x2][y2] != 1) {
                //roll further
                int prevVal = dist[k & 1][x2][y2];
                if (prevVal == 0 || prevVal > d + 1) {
                    dist[k & 1][x2][y2] = d + 1;
                    queue.offer(new int[]{x2, y2, k, d + 1});
                }
            } else {
                //turn and roll
                int prevVal = dist[k & 1 ^ 1][x1][y1];
                if (x1 == destination[0] && y1 == destination[1]) canStop[k & 1] = true;
                if (prevVal == 0 || prevVal > d) {
                    dist[k & 1 ^ 1][x1][y1] = d;
                    queue.offer(new int[]{x1, y1, k ^ 1, d});
                    queue.offer(new int[]{x1, y1, 3 - k, d});
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        if (canStop[0]) ans = Math.min(ans, dist[0][destination[0]][destination[1]]);
        if (canStop[1]) ans = Math.min(ans, dist[1][destination[0]][destination[1]]);
        return ans != Integer.MAX_VALUE ? ans - 1 : -1;
    }
}
