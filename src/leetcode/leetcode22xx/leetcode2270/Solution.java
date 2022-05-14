package leetcode.leetcode22xx.leetcode2270;

public class Solution {
    public int waysToSplitArray(int[] nums) {
        long rightSum = 0, leftSum = 0;
        for (int num : nums) rightSum += num;

        int ans = 0, n = nums.length - 1;
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (leftSum >= rightSum) ans++;
        }
        return ans;
    }
}
