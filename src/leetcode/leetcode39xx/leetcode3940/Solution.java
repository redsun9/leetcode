package leetcode.leetcode39xx.leetcode3940;

public class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int ansLength = 0;
        for (int i = 0, prev = 0, cnt = 0; i < nums.length; i++) {
            if (prev == nums[i]) cnt++;
            else cnt = 1;
            prev = nums[i];
            if (cnt <= k) ansLength++;
        }

        int[] ans = new int[ansLength];
        for (int i = 0, pos = 0, prev = 0, cnt = 0; i < nums.length; i++) {
            if (prev == nums[i]) cnt++;
            else cnt = 1;
            prev = nums[i];
            if (cnt <= k) ans[pos++] = prev;
        }
        return ans;
    }
}
