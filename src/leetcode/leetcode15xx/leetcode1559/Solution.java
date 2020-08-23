package leetcode.leetcode15xx.leetcode1559;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static final int[] moves = {0, 1, 0, -1, 0};

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 || n == 1) return false;
        boolean[][] processed = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (processed[i][j]) continue;
                processed[i][j] = true;
                char c = grid[i][j];
                for (int k = 0; k < 4; k++) {
                    int nextI = i + moves[k];
                    int nextJ = j + moves[k + 1];
                    if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && grid[nextI][nextJ] == c) {
                        queue.add(new int[]{nextI, nextJ, (k + 2) % 4});
                    }
                }
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int currI = poll[0];
                    int currJ = poll[1];
                    int from = poll[2];
                    if (processed[currI][currJ]) return true;
                    processed[currI][currJ] = true;
                    for (int k = 0; k < 4; k++) {
                        if (k == from) continue;
                        int nextI = currI + moves[k];
                        int nextJ = currJ + moves[k + 1];
                        if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && grid[nextI][nextJ] == c) {
                            if (processed[nextI][nextJ]) return true;
                            queue.add(new int[]{nextI, nextJ, (k + 2) % 4});
                        }
                    }
                }
            }
        }
        return false;
    }
}
