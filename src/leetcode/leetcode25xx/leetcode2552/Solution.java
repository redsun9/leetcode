package leetcode.leetcode25xx.leetcode2552;

public class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n];
        long ans = 0;
        for (int j = 0; j < n; j++) {
            int prev = 0;
            for (int i = 0; i < j; i++) {
                if (nums[j] > nums[i]) {
                    prev++;
                    ans += dp[i];
                } else if (nums[j] < nums[i]) {
                    dp[i] += prev;
                }
            }
        }
        return ans;
    }
}
