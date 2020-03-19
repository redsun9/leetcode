package leetcode.leetcode239;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];
        if (k == 1) return nums;
        if (k >= n) {
            int max = nums[0];
            for (int i = 1; i < n; i++) {
                max = Math.max(max, nums[i]);
            }
            return new int[]{max};
        }
        int[] r = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offerLast(i);
            if (i >= k - 1) {
                //noinspection ConstantConditions
                r[ri++] = nums[q.peekFirst()];
            }
        }
        return r;
    }
}