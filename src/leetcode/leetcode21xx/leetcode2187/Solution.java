package leetcode.leetcode21xx.leetcode2187;

public class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo = 1, hi = (long) time[0] * totalTrips;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (check(time, mid, totalTrips)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private static boolean check(int[] time, long val, long totalTrips) {
        for (int t : time) {
            totalTrips -= val / t;
            if (totalTrips <= 0) return true;
        }
        return false;
    }
}
