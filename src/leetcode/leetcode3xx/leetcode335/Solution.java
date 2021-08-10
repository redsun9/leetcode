package leetcode.leetcode3xx.leetcode335;

// we sholud track previous 5 segments and check new on intersection with 1 and 3

public class Solution {
    private static final int[][] moves = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        if (n <= 3) return false;
        int[][] prev = new int[6][4];
        int x2, y2;
        for (int i = 0, i1 = 5, i2 = 2, i3 = 1, i4 = 0, x1 = 0, y1 = 0; i < n; i++, x1 = x2, y1 = y2) {
            x2 = x1 + distance[i] * moves[i & 3][0];
            y2 = y1 + distance[i] * moves[i & 3][1];
            prev[i1][0] = Math.min(x1, x2);
            prev[i1][1] = Math.min(y1, y2);
            prev[i1][2] = Math.max(x1, x2);
            prev[i1][3] = Math.max(y1, y2);
            if (i >= 3 && intersects(prev[i1], prev[i2])) return true;
            if (i >= 4 && intersects(prev[i1], prev[i3])) return true;
            if (i >= 5 && intersects(prev[i1], prev[i4])) return true;
            i4 = i3;
            i3 = i2;
            i2++;
            if (i2 == 6) i2 = 0;
            i1++;
            if (i1 == 6) i1 = 0;
        }
        return false;
    }

    private static boolean intersects(int[] a, int[] b) {
        return a[0] <= b[2] && b[0] <= a[2] && a[1] <= b[3] && b[1] <= a[3];
    }
}
