package leetcode.leetcode21xx.leetcode2172;

import static java.lang.Math.max;

public class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        int n = nums.length;
        int[][] dp = new int[numSlots][1 << n];
        return dfs((1 << n) - 1, n, n, numSlots, nums, dp);

    }

    private static int dfs(int mask, int left, int n, int slot, int[] nums, int[][] dp) {
        if (left == 0) return 0;
        if (dp[slot - 1][mask] == 0) {
            int max = 0;
            if (left <= 2 * (slot - 1)) max = dfs(mask, left, n, slot - 1, nums, dp);
            if (left < 2 * slot) {
                for (int i = 0; i < n; i++) {
                    if ((mask >> i & 1) == 0) continue;
                    mask ^= 1 << i;
                    max = max(max, (nums[i] & slot) + dfs(mask, left - 1, n, slot - 1, nums, dp));
                    mask ^= 1 << i;
                }
            }
            if (left >= 2) {
                for (int i = 0; i < n; i++) {
                    if ((mask >> i & 1) == 0) continue;
                    mask ^= 1 << i;
                    int val1 = nums[i] & slot;
                    for (int j = i + 1; j < n; j++) {
                        if ((mask >> j & 1) == 0) continue;
                        mask ^= 1 << j;
                        max = max(max, val1 + (nums[j] & slot) + dfs(mask, left - 2, n, slot - 1, nums, dp));
                        mask ^= 1 << j;
                    }
                    mask ^= 1 << i;
                }
            }
            dp[slot - 1][mask] = max + 1;
        }
        return dp[slot - 1][mask] - 1;
    }
}
