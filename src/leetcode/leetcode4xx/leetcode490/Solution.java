package leetcode.leetcode4xx.leetcode490;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    private static final int[] moves = {1, 0, -1, 0, 1};

    /**
     * @param maze:        the maze
     * @param start:       the start
     * @param destination: the destination
     * @return whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        maze[start[0]][start[1]] |= 6;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) queue.offer(new int[]{start[0], start[1], i});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            int k = poll[2];
            int x2 = x1 + moves[k];
            int y2 = y1 + moves[k + 1];
            if (x2 >= 0 && y2 >= 0 && x2 < m && y2 < n && maze[x2][y2] != 1) {
                //roll further
                if ((maze[x2][y2] >> (k & 1) & 2) == 0) {
                    maze[x2][y2] |= 2 << (k & 1);
                    queue.offer(new int[]{x2, y2, k});
                }
            } else {
                //turn and roll
                if (x1 == destination[0] && y1 == destination[1]) return true;
                maze[x1][y1] |= 8;
                if ((maze[x1][y1] >> ((k & 1) ^ 1) & 2) == 0) {
                    maze[x1][y1] |= 2 << ((k & 1) ^ 1);
                    queue.offer(new int[]{x1, y1, k ^ 1});
                    queue.offer(new int[]{x1, y1, 3 - k});
                }
            }
        }
        return false;
    }
}
