package leetcode.leetcode8xx.leetcode810;

public class Solution {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;
        if (xor == 0) return true;
        return (nums.length & 1) == 0;
    }
}
