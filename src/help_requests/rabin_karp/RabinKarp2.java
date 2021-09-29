package help_requests.rabin_karp;

public class RabinKarp2 {
    // uses modular arithmetic
    private static final long base = 3;
    private static final int mod = Integer.MAX_VALUE; // prime number

    public static boolean contains(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (m < n) return false;
        if (n == 0) return true;

        long needleHash = 0, haystackHash = 0;
        long pow = 1;
        for (int i = 0; i < n; i++) {
            needleHash += (needle.charAt(i) % 3) * pow;
            if (needleHash >= mod) needleHash %= mod;

            haystackHash += (haystack.charAt(i) % 3) * pow;
            if (haystackHash >= mod) haystackHash %= mod;

            pow *= 3;
            if (pow >= mod) pow %= mod;
        }


        if (needleHash == haystackHash) return true;

        int modInverseOfThree = reverse(3);

        pow = pow * modInverseOfThree % mod;

        for (int start = 1, end = n; end < m; end++, start++) {
            haystackHash = (haystackHash - haystack.charAt(start - 1) % 3);
            if (haystackHash < 0) haystackHash += mod;

            haystackHash = haystackHash * modInverseOfThree % mod;
            haystackHash = haystackHash + haystack.charAt(end) % 3 * pow;
            if (haystackHash >= mod) haystackHash %= mod;
            if (haystackHash == needleHash) return true;
        }
        return false;
    }

    // find multiplicative inverse of a modulo n
    // extended Euclidean algorithm
    private static int reverse(int a) {
        int t = 0, newT = 1, r = mod, newR = a, q, tmp;
        while (newR != 0) {
            q = r / newR;
            tmp = t - q * newT;
            t = newT;
            newT = tmp;
            tmp = r - q * newR;
            r = newR;
            newR = tmp;
        }
        if (r > 1) return -1;
        if (t < 0) t += mod;
        return t;
    }
}
