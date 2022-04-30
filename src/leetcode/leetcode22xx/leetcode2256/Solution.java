package leetcode.leetcode22xx.leetcode2256;

public class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long right = 0;
        for (int num : nums) right += num;
        long min = Math.abs(right / n);
        int ans = n - 1;
        long left = 0;
        for (int i = 0, j = n - 1; j != 0; i++, j--) {
            right -= nums[i];
            left += nums[i];
            long tmp = Math.abs(left / (i + 1) - (right / j));
            if (tmp < min || tmp == min && ans == n - 1) {
                min = tmp;
                ans = i;
            }
        }
        return ans;
    }
}
