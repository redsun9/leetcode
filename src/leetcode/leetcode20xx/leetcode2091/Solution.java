package leetcode.leetcode20xx.leetcode2091;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length, min = nums[0], max = nums[0], posMin = 0, posMax = 0, val;
        for (int i = 1; i < n; i++) {
            val = nums[i];
            if (min > val) {
                min = val;
                posMin = i;
            } else if (max < val) {
                max = val;
                posMax = i;
            }
        }
        int right = max(posMax, posMin);
        int left = min(posMax, posMin);
        return min(min(right + 1, n - left), left + 1 + n - right);
    }
}
