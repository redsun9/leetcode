package leetcode.leetcode37xx.leetcode3756;

public class Solution {
    private static final int p = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] prefSum = new int[n + 1];
        int[] prefNonZero = new int[n + 1];
        long[] prefHash = new long[n + 1];
        long[] tens = new long[n + 1];
        long hash = 0, ten = 1;
        tens[0] = 1;
        for (int i = 0, nonZero = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (digit != 0) {
                nonZero++;
                hash = hash * 10 + digit;
                if (hash >= p) hash %= p;
            }

            prefNonZero[i + 1] = nonZero;
            prefSum[i + 1] = prefSum[i] + digit;
            prefHash[i + 1] = hash;

            ten = ten * 10;
            if (ten >= p) ten %= p;
            tens[i + 1] = ten;
        }


        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0], r = queries[i][1];
            long h = (prefHash[r + 1] - prefHash[l] * tens[prefNonZero[r + 1] - prefNonZero[l]]) % p;
            if (h < 0) h += p;

            h = h * (prefSum[r + 1] - prefSum[l]) % p;
            if (h < 0) h += p;
            ans[i] = (int) h;
        }
        return ans;
    }
}
