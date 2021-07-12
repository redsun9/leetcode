package leetcode.leetcode19xx.leetcode1929;

import java.util.Arrays;

public class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = Arrays.copyOf(nums, n * 2);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }
}
