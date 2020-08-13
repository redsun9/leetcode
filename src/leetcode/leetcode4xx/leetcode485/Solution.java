package leetcode.leetcode4xx.leetcode485;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int curLen = 0;
        for (int num : nums) {
            if (num == 1) curLen++;
            else {
                ans = Math.max(ans, curLen);
                curLen = 0;
            }
        }
        return Math.max(ans, curLen);
    }
}
