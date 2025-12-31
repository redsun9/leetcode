package leetcode.leetcode37xx.leetcode3790;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Solution2 {
    public int minAllOneMultiple(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        return (int) multiplicativeOrder(9L * k);
    }

    // ---------- basic ----------
    private static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private static long mulMod(long a, long b, long mod) {
        return BigInteger.valueOf(a)
                .multiply(BigInteger.valueOf(b))
                .mod(BigInteger.valueOf(mod))
                .longValue();
    }

    private static long powMod(long a, long e, long mod) {
        long r = 1;
        while (e > 0) {
            if ((e & 1) == 1)
                r = mulMod(r, a, mod);
            a = mulMod(a, a, mod);
            e >>= 1;
        }
        return r;
    }

    // ---------- Miller–Rabin ----------
    private static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long p : new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37}) {
            if (n % p == 0) return n == p;
        }

        long d = n - 1, s = 0;
        while ((d & 1) == 0) {
            d >>= 1;
            s++;
        }

        for (long a : new long[]{2, 325, 9375, 28178, 450775, 9780504, 1795265022}) {
            if (a % n == 0) continue;
            long x = powMod(a, d, n);
            if (x == 1 || x == n - 1) continue;
            boolean comp = true;
            for (int r = 1; r < s; r++) {
                x = mulMod(x, x, n);
                if (x == n - 1) {
                    comp = false;
                    break;
                }
            }
            if (comp) return false;
        }
        return true;
    }

    // ---------- Pollard–Rho ----------
    private static long rho(long n) {
        if ((n & 1) == 0) return 2;
        long c = ThreadLocalRandom.current().nextLong(1, n);
        long x = ThreadLocalRandom.current().nextLong(0, n);
        long y = x;

        while (true) {
            x = (mulMod(x, x, n) + c) % n;
            y = (mulMod(y, y, n) + c) % n;
            y = (mulMod(y, y, n) + c) % n;

            long d = gcd(Math.abs(x - y), n);
            if (d == 1) continue;
            if (d == n) return rho(n);
            return d;
        }
    }

    private static void factor(long n, Map<Long, Integer> f) {
        if (n == 1) return;
        if (isPrime(n)) {
            f.merge(n, 1, Integer::sum);
        } else {
            long d = rho(n);
            factor(d, f);
            factor(n / d, f);
        }
    }

    // ---------- φ ----------
    private static long phi(Map<Long, Integer> f) {
        long res = 1;
        for (var e : f.entrySet()) {
            long p = e.getKey();
            int k = e.getValue();
            long t = 1;
            for (int i = 1; i < k; i++) t *= p;
            res *= t * (p - 1);
        }
        return res;
    }

    // ---------- order ----------
    private static long multiplicativeOrder(long m) {
        if (gcd(10, m) != 1) return -1;

        Map<Long, Integer> fm = new HashMap<>();
        factor(m, fm);

        long phiM = phi(fm);

        Map<Long, Integer> fphi = new HashMap<>();
        factor(phiM, fphi);

        long ord = phiM;

        for (long p : fphi.keySet()) {
            while (ord % p == 0) {
                long cand = ord / p;
                if (powMod(10, cand, m) == 1)
                    ord = cand;
                else
                    break;
            }
        }
        return ord;
    }
}
