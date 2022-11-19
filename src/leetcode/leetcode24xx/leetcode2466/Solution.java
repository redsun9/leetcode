package leetcode.leetcode24xx.leetcode2466;

public class Solution {
    private static final int p = 1_000_000_007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int gcd = gcd(zero, one);
        if (gcd != 1) {
            zero /= gcd;
            one /= gcd;
            high /= gcd;
            low = (low + gcd - 1) / gcd;
            if (low > high) return 0;
        }
        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = Math.min(zero, one), i1 = i - zero, i2 = i - one; i <= high; i++, i1++, i2++) {
            if (i1 >= 0) dp[i] += dp[i1];
            if (i2 >= 0) dp[i] += dp[i2];
            if (dp[i] >= p) dp[i] -= p;
        }

        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans += dp[i];
            if (ans >= p) ans -= p;
        }
        return ans;
    }


    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
