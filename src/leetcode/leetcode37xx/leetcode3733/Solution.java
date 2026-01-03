package leetcode.leetcode37xx.leetcode3733;

public class Solution {
    public long minimumTime(int[] d, int[] r) {
        int d1 = d[0], d2 = d[1], r1 = r[0], r2 = r[1];
        long lo = d1 + d2, hi = (d1 + d2) * 2L;
        long lcm = lcm(r1, r2);
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long not1 = mid / r1, not2 = mid / r2, not12 = mid / lcm;
            long yes1 = mid - not1, yes2 = mid - not2, yes1or2 = mid - not12, yes12 = yes1 + yes2 - yes1or2;
            long yes1not2 = yes1 - yes12, yes2not1 = yes2 - yes12;
            boolean ok = Math.max(0, d1 - yes1not2) + Math.max(0, d2 - yes2not1) <= yes12;
            if (ok) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private static long gcd(long a, long b) {
        long c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
