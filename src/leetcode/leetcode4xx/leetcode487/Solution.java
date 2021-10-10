package leetcode.leetcode4xx.leetcode487;

public class Solution {
    /**
     * @param nums: a list of integer
     * @return return an integer, denote  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int left = 0, mid = -1, right = 0, n = nums.length;
        while (right < n) {
            if (nums[right] == 0) {
                left = mid + 1;
                mid = right;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
