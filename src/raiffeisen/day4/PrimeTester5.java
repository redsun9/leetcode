package raiffeisen.day4;

@SuppressWarnings("DuplicatedCode")
public class PrimeTester5 implements PrimeTester {
    //    private static final int[] factors = {2,3}; n < 1_373_653
    private static final int[] factors = {2, 3, 5, 7}; // n < 3_215_031_751
    private final int trivial_limit; // can be extended
    private final int[] p;

    PrimeTester5(int trivialLimit) {
        this.trivial_limit = trivialLimit;
        this.p = new int[trivialLimit];
        for (int i = 2, j = 0; j < trivial_limit; ++i) {
            boolean pr = true;
            for (int k = 2; k * k <= i; ++k)
                if (i % k == 0)
                    pr = false;
            if (pr)
                p[j++] = i;
        }
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

    @Override
    public boolean isPrime(int n) {
        for (int i = 0; i < trivial_limit && p[i] < n; ++i)
            if (n % p[i] == 0)
                return false;
        if (p[trivial_limit - 1] * p[trivial_limit - 1] >= n)
            return true;
        return millerRabin(n);
    }

    private boolean millerRabin(int n) {
        int d = n - 1;
        int r = 0;
        while ((d & 1) == 0) {
            r++;
            d >>= 1;
        }
        //check 2 and 3 (it's enough for number below 10^6)
        for (int factor : factors) {
            if (!millerRabinRound(factor, d, n, r)) return false;
        }
        return true;
    }

    private boolean millerRabinRound(int a, int d, int n, int r) {
        int x = powMod(a, d, n);
        if (x == 1 || x == n - 1) return true;
        for (int i = 1; i < r; i++) {
            x = (int) ((long) x * x % n);
            if (x == n - 1) return true;
        }
        return false;
    }
}
