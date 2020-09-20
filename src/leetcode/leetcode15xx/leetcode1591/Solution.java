package leetcode.leetcode15xx.leetcode1591;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static final int MAX_COLORS = 60;

    public boolean isPrintable(int[][] targetGrid) {
        int m = targetGrid.length;
        int n = targetGrid[0].length;
        int[][][] count = new int[m + 1][n + 1][MAX_COLORS]; //2d sum array for each color
        int[] l = new int[MAX_COLORS];
        int[] r = new int[MAX_COLORS];
        int[] t = new int[MAX_COLORS];
        int[] b = new int[MAX_COLORS];
        Arrays.fill(t, m);
        Arrays.fill(l, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < MAX_COLORS; k++) {
                    count[i + 1][j + 1][k] = count[i + 1][j][k] + count[i][j + 1][k] - count[i][j][k];
                }
                int color = targetGrid[i][j] - 1;
                count[i + 1][j + 1][color]++;
                l[color] = Math.min(l[color], j);
                t[color] = Math.min(t[color], i);
                r[color] = Math.max(r[color], j);
                b[color] = Math.max(b[color], i);
            }
        }

        LinkedList<Integer>[] edges = new LinkedList[MAX_COLORS];

        //for each pair of colours find which colour should be used before
        for (int c1 = 1; c1 < MAX_COLORS; c1++) {
            if (count[m][n][c1] == 0) continue;
            for (int c2 = 0; c2 < c1; c2++) {
                if (count[m][n][c2] == 0) continue;
                //find intersection
                if (
                        l[c1] <= r[c2] && r[c1] >= l[c2] &&
                                t[c1] <= b[c2] && b[c1] >= t[c2]
                ) {
                    int i1 = Math.max(t[c1], t[c2]);
                    int i2 = Math.min(b[c1], b[c2]);
                    int j1 = Math.max(l[c1], l[c2]);
                    int j2 = Math.min(r[c1], r[c2]);
                    int n1 = count[i2 + 1][j2 + 1][c1] - count[i1][j2 + 1][c1] - count[i2 + 1][j1][c1] + count[i1][j1][c1];
                    int n2 = count[i2 + 1][j2 + 1][c2] - count[i1][j2 + 1][c2] - count[i2 + 1][j1][c2] + count[i1][j1][c2];
                    if (n1 != 0 && n2 != 0) return false;
                    //if n1!=0 c1 should be used after c2
                    if (n1 != 0) {
                        if (edges[c1] == null) edges[c1] = new LinkedList<>();
                        edges[c1].add(c2);
                    }
                    //if n2!=0 c2 should be used after c1
                    if (n2 != 0) {
                        if (edges[c2] == null) edges[c2] = new LinkedList<>();
                        edges[c2].add(c1);
                    }
                }
            }
        }
        //check cycles
        boolean[] seen = new boolean[MAX_COLORS];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < MAX_COLORS; i++) {
            if (edges[i] != null) {
                Arrays.fill(seen, false);
                queue.addAll(edges[i]);
                while (!queue.isEmpty()) {
                    int poll = queue.poll();
                    if (poll == i) return false;
                    if (!seen[poll]) {
                        seen[poll] = true;
                        if (edges[poll] != null) {
                            queue.addAll(edges[poll]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
