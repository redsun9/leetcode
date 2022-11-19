package leetcode.leetcode24xx.leetcode2465;

import java.util.Arrays;
import java.util.BitSet;

public class Solution {
    public static final int MAX_VAL = 100;

    public int distinctAverages(int[] nums) {
        BitSet bs = new BitSet(2 * MAX_VAL + 1);
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) bs.set(nums[i] + nums[j]);
        return bs.cardinality();
    }
}
