package leetcode.leetcode21xx.leetcode2154;

public class Solution {
    public int findFinalValue(int[] nums, int original) {
        int meet = 0;
        for (int num : nums) {
            if (num % original == 0) {
                num /= original;
                if ((num & (num - 1)) == 0) meet |= num;
            }
        }
        meet = ~meet;
        return original * (meet ^ meet & (meet - 1));
    }
}
