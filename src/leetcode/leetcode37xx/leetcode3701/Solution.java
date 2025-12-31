package leetcode.leetcode37xx.leetcode3701;

public class Solution {
    public int alternatingSum(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) ans += nums[i];
            else ans -= nums[i];
        }
        return ans;
    }
}
