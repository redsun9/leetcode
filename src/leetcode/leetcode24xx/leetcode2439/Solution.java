package leetcode.leetcode24xx.leetcode2439;

public class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        long sum = nums[0];
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            if (nums[i] >= ans) ans = Math.max(ans, (int) ((sum + i) / (i + 1)));
        }
        return ans;
    }
}
