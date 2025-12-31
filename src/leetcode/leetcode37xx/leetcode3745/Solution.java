package leetcode.leetcode37xx.leetcode3745;

public class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) min = Math.min(min, num);

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max2) {
                if (num > max1) {
                    max2 = max1;
                    max1 = num;
                } else {
                    max2 = num;
                }
            }
        }
        return max1 + max2 - min;
    }
}
