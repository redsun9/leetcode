package leetcode.leetcode36xx.leetcode3670;

public class Solution {
    public long maxProduct(int[] nums) {
        int maxNum = 0;
        for (int num : nums) maxNum = Math.max(maxNum, num);
        if (maxNum <= 1) return 0;
        int highestOneBit = Integer.highestOneBit(maxNum);

        // n*(n-1)/2 и maxNum * bitLength
        if (nums.length <= maxNum * 20 / nums.length) {
            long ans = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if ((nums[i] & nums[j]) == 0) ans = Math.max(ans, (long) nums[i] * nums[j]);
                }
            }
            return ans;
        } else {
            int mask = (highestOneBit << 1) - 1;
            int[] dp = new int[mask + 1];
            for (int num : nums) dp[num] = num;

            for (int i = 1; i <= mask; i++) {
                for (int tmp = i; tmp != 0; tmp &= tmp - 1) {
                    int bit = tmp ^ (tmp & (tmp - 1));
                    dp[i] = Math.max(dp[i], dp[i ^ bit]);
                }
            }
            long ans = 0;
            for (int num : nums) ans = Math.max(ans, (long) num * dp[mask ^ num]);
            return ans;
        }
    }
}
