package leetcode.leetcode29xx.leetcode2908;

public class Solution2 {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        if (n < 3) return -1;

        int[] left = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) left[i] = Math.min(left[i - 1], nums[i]);

        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) right[i] = Math.min(right[i + 1], nums[i]);


        int ans = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 1; i--) {
            if (left[i - 1] < nums[i] && right[i + 1] < nums[i]) {
                ans = Math.min(ans, nums[i] + left[i - 1] + right[i + 1]);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
