package leetcode.leetcode18xx.leetcode1862;

public class Solution {
    private static final int MAX_VALUE = 100_000;
    private static final int MOD = 1_000_000_007;

    public int sumOfFlooredPairs(int[] nums) {
        int[] count = new int[MAX_VALUE + 1];
        for (int num : nums) count[num]++;
        for (int i = 2; i <= MAX_VALUE; i++) count[i] += count[i - 1];
        long ans = 0;
        for (int i = 1; i <= MAX_VALUE; i++) {
            long c = count[i] - count[i - 1];
            if (c == 0) continue;
            for (int j1 = i - 1, j2 = j1 + i, k = 1; j2 <= MAX_VALUE; j1 += i, j2 += i, k++) {
                ans += c * (count[j2] - count[j1]) * k;
                if (ans >= MOD) ans %= MOD;
            }
            if ((MAX_VALUE + 1) % i != 0) {
                ans += c * (count[MAX_VALUE] - count[MAX_VALUE / i * i - 1]) * (MAX_VALUE / i);
                if (ans >= MOD) ans %= MOD;
            }
        }
        return (int) (ans % MOD);
    }
}
