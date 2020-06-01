package leetcode.leetcode14xx.leetcode1464;

public class Solution {
    public int maxProduct(int[] nums) {
        int a = Math.max(nums[0], nums[1]);
        int b = Math.min(nums[0], nums[1]);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] >= a) {
                b = a;
                a = nums[i];
            } else if (nums[i] > b) b = nums[i];
        }
        return (a - 1) * (b - 1);
    }
}
