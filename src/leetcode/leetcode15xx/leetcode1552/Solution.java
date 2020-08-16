package leetcode.leetcode15xx.leetcode1552;

import java.util.Arrays;

public class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        if (m == 2) return position[n - 1] - position[0];
        int lo = 1;
        int hi = (position[n - 1] - position[0]) / (m - 1);
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (check(position, m, n, mid)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    private static boolean check(int[] position, int m, int n, int d) {
        int minReq = position[0] + d;
        m--;
        int i = 1;
        while (i < n && m > 0) {
            if (position[i] >= minReq) {
                m--;
                minReq = position[i] + d;
            }
            i++;
        }
        return m == 0;
    }
}
