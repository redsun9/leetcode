package leetcode.leetcode24xx.leetcode2444;

public class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long ans = 0;
        int leftEqMin = -1, leftEqMax = -1, leftFail = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == minK) leftEqMin = i;
            if (nums[i] == maxK) leftEqMax = i;
            if (nums[i] < minK || nums[i] > maxK) leftFail = i;
            ans += Math.max(Math.min(leftEqMin, leftEqMax) - leftFail, 0);
        }
        return ans;
    }
}
