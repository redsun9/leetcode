package leetcode.leetcode39xx.leetcode3936;

public class Solution {
    public int minimumSwaps(int[] nums) {
        int ans = 0;
        for (int num : nums) if (num == 0) ans++;
        for (int i = nums.length - ans; i < nums.length; i++) {
            if (nums[i] == 0) ans--;
        }
        return ans;
    }
}
