package leetcode.leetcode18xx.leetcode1827;

public class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int ans = 0, prev = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > prev) prev = nums[i];
            else ans += ++prev - nums[i];
        }
        return ans;
    }
}
