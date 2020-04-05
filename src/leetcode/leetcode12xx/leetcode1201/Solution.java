package leetcode.leetcode12xx.leetcode1201;

import java.util.Arrays;

public class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int[] p = {a, b, c};
        Arrays.sort(p);
        if (p[1] % p[0] == 0 && p[2] % p[0] == 0) return nthUglyNumber(n, p[0]);
        if (p[1] % p[0] == 0) return nthUglyNumber(n, p[0], p[2]);
        if (p[2] % p[0] == 0 || p[2] % p[1] == 0) return nthUglyNumber(n, p[0], p[1]);

        long ab = lcd(p[0], p[1]);
        long ac = lcd(p[0], p[2]);
        long bc = lcd(p[1], p[2]);
        long abc = lcd(ab, p[2]);

        int lo = 1;
        int hi = Integer.MAX_VALUE;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int val = g(mid, p[0], p[1], p[2], ab, ac, bc, abc);
            if (val >= n) hi = mid;
            else lo = mid + 1;
        }
        return hi;
    }

    private static int nthUglyNumber(int n, int a, int b) {
        long ab = lcd(a, b);
        int lo = 1;
        int hi = Integer.MAX_VALUE;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int val = g(mid, a, b, ab);
            if (val >= n) hi = mid;
            else lo = mid + 1;
        }
        return hi;
    }

    private static int nthUglyNumber(int n, int a) {
        return n * a;
    }

    private static int g(int n, int a, int b, int c, long ab, long ac, long bc, long abc) {
        return (int) (n / a + n / b + n / c - n / ab - n / ac - n / bc + n / abc);
    }

    private static int g(int n, int a, long b, long ab) {
        return (int) (n / a + n / b - n / ab);
    }

    public static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }

    public static long gcd(long a, long b) {
        long c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }


    public static long lcd(int a, int b) {
        return (long) a * b / gcd(a, b);
    }

    public static long lcd(long a, long b) {
        return (long) a * b / gcd(a, b);
    }
}
