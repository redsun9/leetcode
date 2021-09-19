package leetcode.leetcode20xx.leetcode2012;

public class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] minRight = new int[n + 1];
        minRight[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) minRight[i] = Math.min(minRight[i + 1], nums[i]);

        int ans = 0, maxLeft = nums[0];
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > maxLeft && nums[i] < minRight[i + 1]) ans += 2;
            else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) ans += 1;
            maxLeft = Math.max(maxLeft, nums[i]);
        }
        return ans;
    }
}
