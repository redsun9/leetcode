package leetcode.leetcode0xx.leetcode16;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - ans);
        int num1, curr, threshold;
        for (int i = 0; i < n; i++) {
            num1 = nums[i];
            threshold = target - num1;
            for (int j = i + 1, k = n - 1; j < k; ) {
                curr = nums[j] + nums[k];
                if (Math.abs(threshold - curr) < diff) {
                    ans = num1 + curr;
                    diff = Math.abs(threshold - curr);
                }
                if (curr == threshold) return ans;
                if (curr > threshold) k--;
                else j++;
            }
        }
        return ans;
    }
}
