package leetcode.leetcode19xx.leetcode1970;

import java.util.ArrayDeque;
import java.util.Queue;

// Binary search + bfs
// O(n) - space, O(n*logn) - time

class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public int latestDayToCross(int row, int col, int[][] cells) {
        if (row == 1) return col - 1;
        if (col == 1) return 0;
        int n = row * col;
        int[][] mat = new int[row][col];
        for (int i = 0; i < n; i++) {
            mat[cells[i][0] - 1][cells[i][1] - 1] = i + 1;
        }
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (check(mat, mid, row, col)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }


    private static boolean check(int[][] mat, int day, int row, int col) {
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < col; i++) {
            if (mat[0][i] > day) queue.add(new int[]{0, i});
            visited[0][i] = true;
        }
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1];
            for (int k = 0; k < 4; k++) {
                int x1 = x + moves[k], y1 = y + moves[k + 1];
                if (x1 >= 0 && x1 < row && y1 >= 0 && y1 < col && mat[x1][y1] > day && !visited[x1][y1]) {
                    if (x1 == row - 1) return true;
                    visited[x1][y1] = true;
                    queue.add(new int[]{x1, y1});
                }
            }
        }
        return false;
    }
}
