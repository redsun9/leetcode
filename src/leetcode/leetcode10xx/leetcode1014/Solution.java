package leetcode.leetcode10xx.leetcode1014;

public class Solution {
    public int maxScoreSightseeingPair(int[] nums) {
        int ans = 0;
        int prev = 0;
        for (int a : nums) {
            ans = Math.max(ans, prev + a);
            prev = Math.max(prev, a) - 1;
        }
        return ans;
    }
}
