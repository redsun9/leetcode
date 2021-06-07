package leetcode.leetcode18xx.leetcode1879;

import java.util.Arrays;

public class Solution {
    private static int dfs(int[] a, int[] b, int pos, int n, int mask, int[] dp) {
        if (pos == n) return 0;
        if (dp[mask] == Integer.MAX_VALUE)
            for (int i = 0; i < n; i++)
                if ((mask & (1 << i)) == 0)
                    dp[mask] = Math.min(dp[mask], (a[pos] ^ b[i]) + dfs(a, b, pos + 1, n, mask | (1 << i), dp));
        return dp[mask];
    }

    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return dfs(nums1, nums2, 0, n, 0, dp);
    }
}
