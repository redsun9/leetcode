package leetcode.leetcode23xx.leetcode2341;

public class Solution {
    private static final int MAX_VAL = 100;

    public int[] numberOfPairs(int[] nums) {
        int[] count = new int[MAX_VAL + 1];
        for (int num : nums) count[num]++;
        int pairs = 0;
        for (int a : count) pairs += a >> 1;
        return new int[]{pairs, nums.length - pairs * 2};
    }
}
