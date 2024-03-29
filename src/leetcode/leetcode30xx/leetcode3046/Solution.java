package leetcode.leetcode30xx.leetcode3046;

public class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) if (++count[num] == 3) return false;
        return true;
    }
}
