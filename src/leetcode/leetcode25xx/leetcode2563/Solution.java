package leetcode.leetcode25xx.leetcode2563;

import java.util.Arrays;

public class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return numberOfPairs(nums, upper) - numberOfPairs(nums, lower - 1);
    }

    private static long numberOfPairs(int[] nums, int upper) {
        int n = nums.length;
        long ans = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum <= upper) {
                ans += r - l;
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
