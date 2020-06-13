package leetcode.leetcode4xx.leetcode416;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) for (int i = sum, j = sum - num; j >= 0; i--, j--) dp[i] |= dp[j];
        return dp[sum];
    }
}
