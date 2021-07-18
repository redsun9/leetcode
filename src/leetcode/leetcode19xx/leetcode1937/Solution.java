package leetcode.leetcode19xx.leetcode1937;

public class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;

        long[] prev = new long[n], next = new long[n], tmp;
        for (int i = 0; i < n; i++) prev[i] = points[0][i];

        long max;
        for (int i = 1; i < m; i++) {
            int[] row = points[i];
            max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, prev[j] + j);
                next[j] = max - j;
            }
            max = Integer.MIN_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                max = Math.max(max, prev[j] - j);
                next[j] = Math.max(next[j], max + j) + row[j];
            }
            tmp = prev;
            prev = next;
            next = tmp;
        }

        long ans = 0;
        for (long val : prev) ans = Math.max(ans, val);
        return ans;
    }
}
