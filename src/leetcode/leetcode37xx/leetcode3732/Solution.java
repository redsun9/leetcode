package leetcode.leetcode37xx.leetcode3732;

public class Solution {
    public long maxProduct(int[] nums) {
        long max1 = 0, max2 = 0;
        for (long num : nums) {
            num = Math.abs(num);
            if (max2 < num) {
                if (max1 < num) {
                    max2 = max1;
                    max1 = num;
                } else {
                    max2 = num;
                }
            }
        }
        return max1 * max2 * 100_000;
    }
}
