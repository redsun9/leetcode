package leetcode.leetcode8xx.leetcode878;

public class Solution {
    public static final int p = 1_000_000_007;

    public int nthMagicalNumber(int n, int a, int b) {
        long lcm = lcm(a, b);
        long k = lcm / a + lcm / b - 1;
        long target = n % k;
        long offset = lcm * (n / k);
        if (target == 0) return (int) (offset % p);
        if (target == 1) return (int) ((offset + Math.min(a, b)) % p);
        if (target == k - 1) return (int) ((offset + lcm - Math.min(a, b)) % p);
        long lo = 1;
        long hi = lcm - 1;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long tmp = mid / a + mid / b;
            if (tmp == target && (mid % a == 0 || mid % b == 0)) return (int) ((offset + mid) % p);
            if (tmp < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return (int) ((offset + lo) % p);
    }

    //greatest common divisor
    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }

    //least common multiple
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
