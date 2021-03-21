package leetcode.leetcode17xx.leetcode1793;

public class Solution {
    public int maximumScore(int[] nums, int k) {
        int ans = nums[k];
        int n = nums.length;
        int l = k - 1, r = k + 1;
        int threshold = nums[k];
        while (true) {
            while (l >= 0 && nums[l] >= threshold) l--;
            while (r < n && nums[r] >= threshold) r++;
            ans = Math.max(ans, (r - l - 1) * threshold);
            if (l < 0 && r >= n) return ans;
            threshold = 0;
            if (l >= 0) threshold = nums[l];
            if (r < n) threshold = Math.max(threshold, nums[r]);
        }
    }
}
