package leetcode.leetcode14xx.leetcode1493;

public class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (!zeroExists(nums)) return n - 1;
        int max = 0;
        int prevLen = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int curLen = i - start;
                max = Math.max(max, prevLen + i - start);
                prevLen = curLen;
                start = i + 1;
            }
        }
        max = Math.max(max, prevLen + n - start);
        return max;
    }

    private static boolean zeroExists(int[] nums) {
        for (int num : nums) {
            if (num == 0) return true;
        }
        return false;
    }
}
