package leetcode.leetcode4xx.leetcode494;

import java.util.Arrays;

public class Solution {
    private static final int shift = 1000;

    public int findTargetSumWays(int[] nums, int target) {
        target = Math.abs(target);
        if (target > shift) return 0;
        int[] prev = new int[2 * shift + 1];
        int[] curr = new int[2 * shift + 1];
        prev[shift] = 1;
        int prevSum = 0;
        for (int num : nums) {
            int curSum = prevSum + num;
            Arrays.fill(curr, shift - curSum, shift + curSum + 1, 0);
            for (int i = shift - prevSum; i <= shift + prevSum; i++) {
                curr[i - num] += prev[i];
                curr[i + num] += prev[i];
            }
            int[] t = prev;
            prev = curr;
            curr = t;
            prevSum = curSum;
        }
        return prev[shift + target];
    }
}
