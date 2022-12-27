package leetcode.leetcode25xx.leetcode2513;

public class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int lo = uniqueCnt1 + uniqueCnt2, hi = Integer.MAX_VALUE;
        long lcm = lcm(divisor1, divisor2);
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long a = mid - mid / divisor1;
            long b = mid - mid / divisor2;
            long notAnotB = mid / lcm;
            long aOrB = mid - notAnotB;
            if (a >= uniqueCnt1 && b >= uniqueCnt2 && aOrB >= uniqueCnt1 + uniqueCnt2) hi = mid;
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
