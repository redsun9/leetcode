package leetcode.leetcode20xx.leetcode2057;

public class Solution {
    public int smallestEqual(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) if (nums[i] == i % 10) return i;
        return -1;
    }
}
