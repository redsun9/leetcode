package leetcode.leetcode4xx.leetcode413;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        int ans = 0;
        for (int left = 0, right = 2, d = nums[1] - nums[0]; right <= n; right++) {
            if (right == n || nums[right] - nums[right - 1] != d) {
                int k = right - left;
                ans += (k - 1) * (k - 2);
                left = right - 1;
                if (right != n) d = nums[right] - nums[right - 1];
            }
        }
        return ans / 2;
    }
}
