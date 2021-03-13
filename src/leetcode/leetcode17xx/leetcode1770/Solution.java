package leetcode.leetcode17xx.leetcode1770;

public class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        for (int k = 1; k <= m; k++) {
            int multiplier = multipliers[k - 1];
            curr[0] = prev[0] + nums[n - k] * multiplier;
            curr[k] = prev[k - 1] + nums[k - 1] * multiplier;
            for (int i = 1; i < k; i++) {
                curr[i] = Math.max(prev[i - 1] + nums[i - 1] * multiplier, prev[i] + nums[n + i - k] * multiplier);
            }
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= m; i++) {
            ans = Math.max(ans, prev[i]);
        }
        return ans;
    }
}
