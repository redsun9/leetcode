package leetcode.leetcode6xx.leetcode629;

import java.util.Arrays;

public class Solution {
    public static final int p = 1_000_000_007;

    private static int kInversePairs(int n, int k, int[][] cache) {
        if (k == 0) return 1;
        if (n <= 1) return 0;
        if (k == 1) return n - 1;
        if (n * (n - 1) < 2 * k) return 0;
        if (cache[n][k] == -1) {
            long ans = 0;
            for (int i = Math.min(n - 1, k); i >= 0; i--) {
                ans += kInversePairs(n - 1, k - i, cache);
            }
            cache[n][k] = (int) (ans%p);
        }
        return cache[n][k];
    }

    public int kInversePairs(int n, int k) {
        int[][] cache = new int[n + 1][k + 1];
        for (int[] arr : cache) Arrays.fill(arr, -1);
        return kInversePairs(n, k, cache);
    }
}
