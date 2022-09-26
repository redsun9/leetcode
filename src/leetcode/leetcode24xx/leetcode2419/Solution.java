package leetcode.leetcode24xx.leetcode2419;

public class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0, maxVal = 0, curr = 0;
        for (int num : nums) {
            if (num > maxVal) {
                ans = 1;
                curr = 1;
                maxVal = num;
            } else if (num == maxVal) {
                curr++;
                ans = Math.max(ans, curr);
            } else curr = 0;
        }
        return ans;
    }
}
