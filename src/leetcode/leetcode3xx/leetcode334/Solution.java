package leetcode.leetcode3xx.leetcode334;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > b) return true;
            if (num > a) b = num;
            else a = num;
        }
        return false;
    }
}
