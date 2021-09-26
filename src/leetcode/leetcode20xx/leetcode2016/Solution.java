package leetcode.leetcode20xx.leetcode2016;

public class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > min) ans = Math.max(ans, num - min);
            else min = num;
        }
        return ans;
    }
}
