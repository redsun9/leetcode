package leetcode.leetcode21xx.leetcode2104;

import java.util.Stack;

public class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = sumMaxForSubarrays(nums);
        for (int i = 0; i < n; i++) nums[i] = -nums[i];
        ans += sumMaxForSubarrays(nums);
        for (int i = 0; i < n; i++) nums[i] = -nums[i];
        return ans;
    }

    private static long sumMaxForSubarrays(int[] nums) {
        int n = nums.length;
        int[] left = new int[n], right = new int[n];

        Stack<Integer> mq = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!mq.isEmpty() && nums[mq.peek()] <= nums[i]) left[i] += left[mq.pop()] + 1;
            mq.push(i);
        }
        mq.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!mq.isEmpty() && nums[mq.peek()] < nums[i]) right[i] += right[mq.pop()] + 1;
            mq.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) ans += (left[i] + 1L) * (right[i] + 1) * nums[i];
        return ans;
    }
}
