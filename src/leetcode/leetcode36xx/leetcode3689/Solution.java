package leetcode.leetcode36xx.leetcode3689;

public class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return ((long) max - min) * k;
    }
}
