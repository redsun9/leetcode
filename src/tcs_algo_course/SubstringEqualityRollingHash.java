package tcs_algo_course;

@SuppressWarnings("SpellCheckingInspection")
public class SubstringEqualityRollingHash {
    private static final long[] bases = {100_003/*, 100_019, 100_043*/};
    private static final long mod = Integer.MAX_VALUE;
    private static final int NUMBER_BASES = bases.length;
    private final long[][] pows;
    private final long[][] lhs;

    public SubstringEqualityRollingHash(String s) {
        int n = s.length();
        pows = new long[NUMBER_BASES][n + 1];
        lhs = new long[NUMBER_BASES][n + 1];
        for (int k = 0; k < NUMBER_BASES; k++) {
            long base = bases[k];
            long[] pow = pows[k];
            long[] lh = lhs[k];
            pow[0] = 1;
            for (int i = 0; i < n; i++) {
                pow[i + 1] = pow[i] * base % mod;
                lh[i + 1] = (lh[i] * base + s.charAt(i)) % mod;
            }
        }
    }

    public boolean isEqual(int a, int b, int c, int d) {
        if (b - a != d - c) return false;
        for (int k = 0; k < NUMBER_BASES; k++) {
            long h1 = (lhs[k][b] - lhs[k][a] * pows[k][b - a]) % mod;
            if (h1 < 0) h1 += mod;
            long h2 = (lhs[k][d] - lhs[k][c] * pows[k][d - c]) % mod;
            if (h2 < 0) h2 += mod;
            if (h1 != h2) return false;
        }
        return true;
    }
}
