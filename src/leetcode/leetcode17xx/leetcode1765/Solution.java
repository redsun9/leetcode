package leetcode.leetcode17xx.leetcode1765;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public static final int[] moves = {1, 0, -1, 0, 1};

    public int[][] highestPeak(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int i2 = i + moves[k];
                        int j2 = j + moves[k + 1];
                        if (i2 >= 0 && i2 < m && j2 >= 0 && j2 < n && a[i2][j2] == 0) {
                            a[i2][j2] = 2;
                            q.addLast(i2);
                            q.addLast(j2);
                        }
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            Integer i1 = q.pollFirst();
            Integer j1 = q.pollFirst();
            int val = a[i1][j1];
            for (int k = 0; k < 4; k++) {
                int i2 = i1 + moves[k];
                int j2 = j1 + moves[k + 1];
                if (i2 >= 0 && i2 < m && j2 >= 0 && j2 < n && a[i2][j2] == 0) {
                    a[i2][j2] = val + 1;
                    q.addLast(i2);
                    q.addLast(j2);
                }
            }
        }
        for (int[] arr : a) for (int i = 0; i < n; i++) arr[i]--;
        return a;
    }
}
