package leetcode.leetcode28xx.leetcode2873;

public class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long max = nums[0], maxDiff = nums[0] - nums[1], ans = 0;
        for (int i = 2; i < n; i++) {
            long c = nums[i];
            maxDiff = Math.max(maxDiff, max - nums[i - 1]);
            ans = Math.max(ans, c * maxDiff);
            max = Math.max(max, nums[i - 1]);
        }
        return ans;
    }
}
