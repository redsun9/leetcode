package leetcode.leetcode0xx.leetcode80;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int pos = 1;
        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[pos - 1]) nums[++pos] = nums[i];
        }
        return pos + 1;
    }
}
