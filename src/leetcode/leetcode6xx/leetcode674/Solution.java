package leetcode.leetcode6xx.leetcode674;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int ans = 0;
        int start = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans = Math.max(ans, i - start);
                start = i;
            }
        }
        ans = Math.max(ans, n - start);
        return ans;
    }
}
