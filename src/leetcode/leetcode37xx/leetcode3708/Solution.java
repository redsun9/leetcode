package leetcode.leetcode37xx.leetcode3708;

public class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 2;
        for (int i = 2, curr = 2; i < nums.length; i++) {
            if (nums[i - 2] + nums[i - 1] == nums[i]) ans = Math.max(ans, ++curr);
            else curr = 2;
        }
        return ans;
    }
}
