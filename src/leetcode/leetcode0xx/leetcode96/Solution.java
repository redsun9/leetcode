package leetcode.leetcode0xx.leetcode96;

import java.util.Arrays;

public class Solution {
    private static final int[] dp = new int[20];

    static {
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
    }

    public int numTrees(int n) {
        if (dp[n] != -1) return dp[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += numTrees(i) * numTrees(n - 1 - i);
        }
        dp[n] = ans;
        return ans;
    }
}
