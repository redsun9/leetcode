package leetcode.leetcode10xx.leetcode1011;

public class Solution {
    public int shipWithinDays(int[] weights, int d) {
        int lo = 0;
        int hi = 0;
        for (Integer weight : weights) {
            lo = Math.max(lo, weight);
            hi += weight;
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(weights, mid, d)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private static boolean check(int[] weights, int w, int d) {
        int cur = 0;
        for (Integer weight : weights) {
            cur += weight;
            if (cur > w) {
                cur = weight;
                d--;
                if (d < 0) return false;
            }
        }
        d--;
        return d >= 0;
    }
}
