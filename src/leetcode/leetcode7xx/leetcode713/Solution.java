package leetcode.leetcode7xx.leetcode713;

public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if (k <= 1 || n == 0) return 0;
        long curr = 1;
        int ans = 0;
        for (int right = 0, left = 0; right < n; right++) {
            curr *= nums[right];
            while (curr >= k) curr /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}
