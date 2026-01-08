package leetcode.leetcode37xx.leetcode3702;

public class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length, xor = 0;
        boolean nonZero = false;
        for (int num : nums) {
            xor ^= num;
            if (num != 0) nonZero = true;
        }
        return xor != 0 ? n : nonZero ? n - 1 : 0;
    }
}
