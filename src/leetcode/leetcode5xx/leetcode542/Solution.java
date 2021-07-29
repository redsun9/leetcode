package leetcode.leetcode5xx.leetcode542;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int i, j, k, i1, j1;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                    for (k = 0; k < 4; k++) {
                        i1 = i + moves[k];
                        j1 = j + moves[k + 1];
                        if (i1 >= 0 && i1 < m && j1 >= 0 && j1 < n && mat[i1][j1] == 0) {
                            queue.add(new int[]{i, j});
                            mat[i][j] = 1;
                            break;
                        }
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            i = poll[0];
            j = poll[1];
            for (k = 0; k < 4; k++) {
                i1 = i + moves[k];
                j1 = j + moves[k + 1];
                if (i1 >= 0 && i1 < m && j1 >= 0 && j1 < n && mat[i1][j1] == -1) {
                    mat[i1][j1] = mat[i][j] + 1;
                    queue.add(new int[]{i1, j1});
                }
            }
        }
        return mat;
    }
}
