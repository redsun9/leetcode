package leetcode.leetcode17xx.leetcode1749;

public class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int curMinSum = 0, curMaxSum = 0, ans = 0;
        for (int num : nums) {
            curMinSum += num;
            curMaxSum += num;
            if (curMaxSum < 0) {
                curMaxSum = 0;
            } else if (curMaxSum > ans) ans = curMaxSum;
            if (curMinSum > 0) {
                curMinSum = 0;
            } else if (-curMinSum > ans) ans = -curMinSum;
        }
        return ans;
    }
}
