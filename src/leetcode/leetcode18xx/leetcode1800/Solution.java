package leetcode.leetcode18xx.leetcode1800;

public class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = 0;
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int sum = nums[i];
            while (i < n - 1 && nums[i] < nums[i + 1]) sum += nums[++i];
            ans = Math.max(ans, sum);
            i++;
        }
        return ans;
    }
}
