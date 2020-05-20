package leetcode.leetcode8xx.leetcode891;

import java.util.Arrays;

public class Solution {
    private static final int m = 1_000_000_007;

    public int sumSubseqWidths(int[] a) {
        int n = a.length;
        if (n <= 1) return 0;
        long ans = 0;

        long[] modsOf2 = new long[n];
        modsOf2[0] = 1;
        for (int i = 1; i < n; i++) {
            modsOf2[i] = modsOf2[i - 1] * 2 % m;
        }

        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            ans += a[i] * (m - modsOf2[n - i - 1] + modsOf2[i]);
            ans %= m;
        }
        return (int) ans;
    }
}
