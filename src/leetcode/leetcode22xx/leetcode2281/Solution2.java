package leetcode.leetcode22xx.leetcode2281;

// O(n^3) - time, O(1) - space
public class Solution2 {
    private static final int MOD = 1_000_000_007;

    public int totalStrength(int[] a) {
        int n = a.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long sum = a[i], min = a[i];
                for (int k = i + 1; k <= j; k++) {
                    sum += a[k];
                    if (sum >= MOD) sum -= MOD;
                    min = Math.min(min, a[k]);
                }
                ans = (ans + sum * min) % MOD;
            }
        }
        return (int) ans;
    }
}
