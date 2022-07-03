package leetcode.leetcode23xx.leetcode2327;

// Dummy solution
// O(n*(forget-delay))
public class Solution2 {
    private static final int p = 1_000_000_007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = delay; i < n; i++) {
            for (int j = Math.max(i - forget + 1, 0); j <= i - delay; j++) {
                dp[i] += dp[j];
                if (dp[i] >= p) dp[i] -= p;
            }
        }
        int ans = 0;
        for (int i = Math.abs(n - forget); i < n; i++) {
            ans += dp[i];
            if (ans >= p) ans -= p;
        }
        return ans;
    }
}
