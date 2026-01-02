package leetcode.leetcode37xx.leetcode3738;

public class Solution2 {
    public int longestSubarray(int[] nums) {
        int res = 1, j = 0, prev_len = 0;
        for (int i = 1; i <= nums.length; ++i) {
            if (i == nums.length || nums[i - 1] > nums[i]) {
                int len = i - j;
                res = Math.max(res, len + 1);
                if (j > 1 && nums[j - 2] <= nums[j])
                    res = Math.max(res, len + prev_len);
                if (j != 0 && j + 1 < i && nums[j - 1] <= nums[j + 1])
                    res = Math.max(res, len + prev_len);
                j = i;
                prev_len = len;
            }
        }
        return Math.min(res, nums.length);
    }
}
