package raiffeisen.day4;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/*
    support numbers from 2 to Integer.MAX_VALUE
    Three stages:
    1. try first primes
    2. Miller–Rabin probabilistic primality test
    3. Baillie–PSW primality test ( Combination of strong Fermat probable prime and strong Lucas probable prime test)
 */

public class PrimeTester3 implements PrimeTester {
    private final static int trivial_limit = 10; // can be extended
    private final int[] p = new int[trivial_limit];

    public PrimeTester3() {
        for (int i = 2, j = 0; j < trivial_limit; ++i) {
            boolean pr = true;
            for (int k = 2; k * k <= i; ++k)
                if (i % k == 0)
                    pr = false;
            if (pr)
                p[j++] = i;
        }
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

    private static int powMod(int a, int b, int m) {
        int res = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = (int) (((long) res * a) % m);
                b--;
            } else {
                a = (int) (((long) a * a) % m);
                b >>= 1;
            }
        }
        return res;
    }

    private boolean millerRabin(int n) {
        int b = 2;
        for (int g; (g = gcd(n, b)) != 1; ++b)
            if (n > g)
                return false;
        int p = 0, q = n - 1;
        while ((q & 1) == 0) {
            p++;
            q >>= 1;
        }
        int rem = powMod(b, q, n);
        if (rem == 1 || rem == n - 1)
            return true;
        for (int i = 1; i < p; ++i) {
            rem = (int) (((long) rem * rem) % n);
            if (rem == n - 1) return true;
        }
        return false;
    }

    private static int jacobi(int a, int b) {
        if (a == 0) return 0;
        if (a == 1) return 1;
        if (a < 0)
            if ((b & 2) == 0)
                return jacobi(-a, b);
            else
                return -jacobi(-a, b);
        int a1 = a, e = 0;
        while ((a1 & 1) == 0) {
            a1 >>= 1;
            e++;
        }
        int s;
        if ((e & 1) == 0 || (b & 7) == 1 || (b & 7) == 7)
            s = 1;
        else
            s = -1;
        if ((b & 3) == 3 && (a1 & 3) == 3)
            s = -s;
        if (a1 == 1)
            return s;
        return (int) ((long) s * jacobi(b % a1, a1));
    }

    private static boolean bpsw(int n) {
        int sqrt = (int) Math.round(sqrt(n));
        if (sqrt * sqrt == n) return false;
        int dd = 5;
        for (; ; ) {
            int g = gcd(n, abs(dd));
            if (1 < g && g < n) return false;
            if (jacobi(dd, n) == -1) break;
            dd = dd < 0 ? -dd + 2 : -dd - 2;
        }
        int p = 1, q = (int) (((long) p * p - dd) / 4);
        int d = n + 1, s = 0;
        while ((d & 1) == 0) {
            ++s;
            d >>= 1;
        }
        long u = 1, v = p, u2m = 1, v2m = p, qm = q, qm2 = q * 2L, qkd = q;
        for (int mask = 2; mask <= d; mask <<= 1) {
            u2m = (u2m * v2m) % n;
            v2m = (v2m * v2m) % n;
            while (v2m < qm2) v2m += n;
            v2m -= qm2;
            qm = (qm * qm) % n;
            qm2 = qm * 2;
            if ((d & mask) != 0) {
                long t1 = (u2m * v) % n, t2 = (v2m * u) % n,
                        t3 = (v2m * v) % n, t4 = (((u2m * u) % n)
                        * dd) % n;
                u = t1 + t2;
                if ((u & 1) != 0) u += n;
                u = (u >> 1) % n;
                v = t3 + t4;
                if ((v & 1) != 0) v += n;
                v = (v >> 1) % n;
                qkd = (qkd * qm) % n;
            }
        }
        if (u == 0 || v == 0) return true;
        long qkd2 = qkd * 2;
        for (int r = 1; r < s; ++r) {
            v = (v * v) % n - qkd2;
            if (v < 0) v += n;
            if (v < 0) v += n;
            if (v >= n) v -= n;
            if (v >= n) v -= n;
            if (v == 0) return true;
            if (r < s - 1) {
                qkd = (qkd * qkd) % n;
                qkd2 = qkd * 2;
            }
        }
        return false;
    }

    public boolean isPrime(int n) { // эту функцию нужно вызывать для проверки на простоту
        for (int i = 0; i < trivial_limit && p[i] < n; ++i)
            if (n % p[i] == 0)
                return false;
        if (p[trivial_limit - 1] * p[trivial_limit - 1] >= n)
            return true;
        if (!millerRabin(n))
            return false;
        return bpsw(n);
    }
}
