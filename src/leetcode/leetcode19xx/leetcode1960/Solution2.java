package leetcode.leetcode19xx.leetcode1960;

public class Solution2 {
    private static final long base = 29L;
    private static final long mod = Integer.MAX_VALUE;

    private static boolean isPalindromic(int l, int r, long[] lh, long[] rh, long[] pow) {
        return lh(l, r, lh, pow) == rh(l, r, rh, pow);
    }

    private static long lh(int l, int r, long[] hash, long[] pow) {
        long ans = (hash[r] - hash[l] * pow[r - l]) % mod;
        if (ans < 0) ans += mod;
        return ans;
    }

    private static long rh(int l, int r, long[] hash, long[] pow) {
        long ans = (hash[l] - hash[r] * pow[r - l]) % mod;
        if (ans < 0) ans += mod;
        return ans;
    }

    public long maxProduct(String s) {
        int n = s.length();

        long[] pow = new long[n + 1]; // pow[i] = BASE^i
        pow[0] = 1;
        for (int i = 1; i <= n; i++) pow[i] = pow[i - 1] * base % mod;

        long[] lh = new long[n + 1]; // hash[i] is hash value from str[0..i)
        for (int i = 1; i <= n; i++) lh[i] = (lh[i - 1] * base + s.charAt(i - 1) - 'a') % mod;

        long[] rh = new long[n + 1]; // hash[i] is hash value from str[i..n)
        for (int i = n - 1; i >= 0; i--) rh[i] = (rh[i + 1] * base + s.charAt(i) - 'a') % mod;

        int[] left = new int[n];
        for (int i = 0, max = 1; i < n; i++) {
            if (max < i && isPalindromic(i - max - 1, i + 1, lh, rh, pow)) max += 2;
            left[i] = max;
        }

        int[] right = new int[n];
        for (int i = n - 1, max = 1; i >= 0; i--) {
            if (i + max + 2 <= n && isPalindromic(i, i + max + 2, lh, rh, pow)) max += 2;
            right[i] = max;
        }

        long ans = 1;
        for (int i = 1; i < n; i++) ans = Math.max(ans, (long) left[i - 1] * right[i]);
        return ans;
    }
}
