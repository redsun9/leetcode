package leetcode.leetcode22xx.leetcode2294;

import java.util.Arrays;

public class Solution {
    public int partitionArray(int[] nums, int k) {
        int ans = 0, n = nums.length, i = 0;
        Arrays.sort(nums);
        while (i < n) {
            int threshold = nums[i] + k;
            while (i < n && nums[i] <= threshold) i++;
            ans++;
        }
        return ans;
    }
}
