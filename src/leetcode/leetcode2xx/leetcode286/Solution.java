package leetcode.leetcode2xx.leetcode286;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (rooms[i][j] == 0) queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x1 = poll[0], y1 = poll[1], d = rooms[x1][y1] + 1;
            for (int k = 0; k < 4; k++) {
                int x2 = x1 + moves[k], y2 = y1 + moves[k + 1];
                if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n && rooms[x2][y2] == Integer.MAX_VALUE) {
                    rooms[x2][y2] = d;
                    queue.add(new int[]{x2, y2});
                }
            }
        }
    }
}
