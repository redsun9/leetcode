package leetcode.leetcode7xx.leetcode775;

public class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 2) return true;
        for (int a = nums[0], i = 2; i < n; i++) {
            if (a > nums[i]) return false;
            a = Math.max(a, nums[i - 1]);
        }
        return true;
    }
}
