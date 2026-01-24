package leetcode.leetcode38xx.leetcode3809;

import static java.lang.Math.abs;

public class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int best = -1, n = towers.length;
        for (int i = 0; i < n; i++) {
            int[] tower = towers[i];
            if (abs(tower[0] - center[0]) + abs(tower[1] - center[1]) > radius) continue;
            if (best == -1 || better(tower, towers[best])) best = i;
        }
        return best == -1 ? new int[]{-1, -1} : new int[]{towers[best][0], towers[best][1]};
    }

    private static boolean better(int[] a, int[] b) {
        if (a[2] != b[2]) return a[2] > b[2];
        if (a[0] != b[0]) return a[0] < b[0];
        else return a[1] <= b[1];
    }
}
