package leetcode.leetcode9xx.leetcode945;

import java.util.Arrays;

public class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, prev = -1;
        for (int num : nums) {
            ans += Math.max(prev + 1 - num, 0);
            prev = Math.max(prev + 1, num);
        }
        return ans;
    }
}
