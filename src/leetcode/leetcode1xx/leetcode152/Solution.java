package leetcode.leetcode1xx.leetcode152;

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        // Напишите ваш код здесь...
        int ans = nums[0];

        int curProduct = 0;
        int prodToFirstNegative = 0;

        for (Integer num : nums) {
            if (num == 0) {
                curProduct = 0;
                prodToFirstNegative = 0;
            } else if (curProduct == 0) {
                curProduct = num;
            } else curProduct *= num;

            if (curProduct >= 0) ans = Math.max(ans, curProduct);
            if (curProduct < 0 && prodToFirstNegative != 0) ans = Math.max(ans, curProduct / prodToFirstNegative);
            if (curProduct < 0 && prodToFirstNegative == 0) prodToFirstNegative = curProduct;
        }
        return ans;
    }
}
