package leetcode.leetcode22xx.leetcode2293;

public class Solution {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        while (n != 1) {
            for (int i = 0, j = 0, k = 1; k < n; i++, j += 2, k += 2) {
                if ((i & 1) == 0) nums[i] = Math.min(nums[j], nums[k]);
                else nums[i] = Math.max(nums[j], nums[k]);
            }
            n /= 2;
        }
        return nums[0];
    }
}
