package leetcode.leetcode0xx.leetcode27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 0) return 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] != val) nums[i++] = nums[j];
        }
        return i;
    }
}
