package leetcode.leetcode11xx.leetcode1147;

public class Solution {
    private static final long base = 29L;
    private static final long mod = Integer.MAX_VALUE;

    public int longestDecomposition(String str) {
        int n = str.length();
        long[] hash = new long[n + 1]; // hash[i] is hash value from str[0..i]
        long[] pow = new long[n + 1]; // pow[i] = BASE^i
        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            hash[i] = (hash[i - 1] * base + str.charAt(i - 1)) % mod;
            pow[i] = pow[i - 1] * base % mod;
        }
        int ans = 0;
        int i = 1, start = 0, j = n - 1, end = n;
        while (i <= j) {
            if (getHash(start, i, hash, pow) == getHash(j, end, hash, pow)) {
                ans += 2;
                start = i;
                end = j;
            }
            i++;
            j--;
        }
        if (start != end) ans++;
        return ans;
    }

    private static long getHash(int l, int r, long[] hash, long[] pow) {
        return (hash[r] - hash[l] * pow[r - l] % mod + mod) % mod;
    }
}
