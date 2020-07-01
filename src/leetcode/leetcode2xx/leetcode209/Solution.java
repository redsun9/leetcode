package leetcode.leetcode2xx.leetcode209;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int curS = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < n; i++) {
            curS += nums[i];
            while (curS >= s) {
                ans = Math.min(ans, i - j + 1);
                curS -= nums[j++];
            }
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }
}
