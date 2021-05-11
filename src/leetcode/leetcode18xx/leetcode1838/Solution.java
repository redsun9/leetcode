package leetcode.leetcode18xx.leetcode1838;

import java.util.Arrays;

public class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int l = 0, r = 0, used = 0, prev = nums[0]; r < n; ) {
            used += (nums[r] - prev) * (r - l);
            while (used > k) used = used - nums[r] + nums[l++];
            prev = nums[r++];
            while (r < n && nums[r] == prev) r++;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
