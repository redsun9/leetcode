package leetcode.leetcode23xx.leetcode2327;

// O(n)
public class Solution3 {
    private static final int p = 1_000_000_007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = delay, sum = 0; i < n; i++) {
            sum += dp[i - delay];
            if (i >= forget) sum -= dp[i - forget];
            if (sum >= p) sum -= p;
            if (sum < 0) sum += p;
            dp[i] = sum;
        }
        int ans = 0;
        for (int i = Math.abs(n - forget); i < n; i++) {
            ans += dp[i];
            if (ans >= p) ans -= p;
        }
        return ans;
    }
}
