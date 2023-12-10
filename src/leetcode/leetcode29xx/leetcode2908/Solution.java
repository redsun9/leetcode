package leetcode.leetcode29xx.leetcode2908;

public class Solution {
    public int minimumSum(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] >= nums[j]) continue;
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] >= nums[j]) continue;
                    ans = Math.min(ans, nums[i] + nums[j] + nums[k]);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
