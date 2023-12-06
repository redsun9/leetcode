package leetcode.leetcode25xx.leetcode2568;

public class Solution {
    public int minImpossibleOR(int[] nums) {
        int powersOfTwoBitSet = 0;
        for (int num : nums) if ((num & (num - 1)) == 0) powersOfTwoBitSet |= num;
        return ~powersOfTwoBitSet & -~powersOfTwoBitSet;
    }
}
