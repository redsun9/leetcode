package leetcode.leetcode24xx.leetcode2401;

public class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int l = 0, r = 0, mask = 0; l < n; l++) {
            while (r < n && (mask & nums[r]) == 0) mask |= nums[r++];
            ans = Math.max(ans, r - l);
            mask ^= nums[l];
        }
        return ans;
    }
}
