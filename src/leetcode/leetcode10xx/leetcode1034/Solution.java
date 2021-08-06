package leetcode.leetcode10xx.leetcode1034;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private static final int cSeen = -1;
    private static final int cInner = -2;
    private static final int cBorder = -3;
    private static final int[] moves = {1, 0, -1, 0, 1};

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length, n = grid[0].length;
        int compColor = grid[r0][c0];
        if (compColor == color) return grid;
        Queue<int[]> toReColor = new ArrayDeque<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r0, c0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x1 = poll[0], y1 = poll[1];
            boolean isBorder = x1 == 0 || x1 == m - 1 || y1 == 0 || y1 == n - 1;
            for (int k = 0; k < 4; k++) {
                int x2 = x1 + moves[k], y2 = y1 + moves[k + 1];
                if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n) {
                    int newCellColor = grid[x2][y2];
                    isBorder |= newCellColor != compColor && newCellColor != cBorder
                            && newCellColor != cInner && newCellColor != cSeen;
                    if (newCellColor == compColor) {
                        queue.add(new int[]{x2, y2});
                        grid[x2][y2] = cSeen;
                    }
                }
            }
            grid[x1][y1] = isBorder ? cBorder : cInner;
            toReColor.add(poll);
        }
        while (!toReColor.isEmpty()) {
            int[] poll = toReColor.poll();
            int x1 = poll[0], y1 = poll[1];
            grid[x1][y1] = grid[x1][y1] == cBorder ? color : compColor;
        }
        return grid;
    }
}
