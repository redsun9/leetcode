package leetcode.leetcode9xx.leetcode934;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static final int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int shortestBridge(int[][] a) {
        Queue<Integer> islandI = new ArrayDeque<>();
        Queue<Integer> islandJ = new ArrayDeque<>();
        int m = a.length;
        int n = a[0].length;
        int i = 0;
        boolean found = false;
        while (i < m && !found) {
            int j = 0;
            while (j < n && !found) {
                if (a[i][j] == 1) {
                    islandI.add(i);
                    islandJ.add(j);
                    found = true;
                }
                j++;
            }
            i++;
        }
        Queue<Integer> queueI = new ArrayDeque<>();
        Queue<Integer> queueJ = new ArrayDeque<>();
        while (!islandI.isEmpty()) {
            int cellI = islandI.poll();
            int cellJ = islandJ.poll();
            if (a[cellI][cellJ] == -1) continue;
            a[cellI][cellJ] = -1;
            for (int[] move : moves) {
                int nextCellI = cellI + move[0];
                int nextCellJ = cellJ + move[1];
                if (nextCellI >= 0 && nextCellI < m && nextCellJ >= 0 && nextCellJ < n) {
                    if (a[nextCellI][nextCellJ] == 0) {
                        queueI.add(nextCellI);
                        queueJ.add(nextCellJ);
                        a[nextCellI][nextCellJ] = 2;
                    } else if (a[nextCellI][nextCellJ] == 1) {
                        islandI.add(nextCellI);
                        islandJ.add(nextCellJ);
                    }
                }
            }
        }
        while (true) {
            int cellI = queueI.poll();
            int cellJ = queueJ.poll();
            int curValue = a[cellI][cellJ];
            for (int[] move : moves) {
                int nextCellI = cellI + move[0];
                int nextCellJ = cellJ + move[1];
                if (nextCellI >= 0 && nextCellI < m && nextCellJ >= 0 && nextCellJ < n) {
                    if (a[nextCellI][nextCellJ] == 1) return curValue - 1;
                    if (a[nextCellI][nextCellJ] == 0) {
                        a[nextCellI][nextCellJ] = curValue + 1;
                        queueI.add(nextCellI);
                        queueJ.add(nextCellJ);
                    }
                }
            }
        }
    }
}
