package leetcode.leetcode16xx.leetcode1696;

import java.util.ArrayDeque;

@SuppressWarnings("ConstantConditions")
public class Solution2 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int curr = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0, j = -k; i < n; i++, j++) {
            curr = nums[i] + (queue.isEmpty() ? 0 : nums[queue.getLast()]);
            while (!queue.isEmpty() && curr >= nums[queue.peekFirst()]) queue.pollFirst();
            queue.addFirst(i);
            if (queue.peekLast() <= j) queue.pollLast();
            nums[i] = curr;
        }
        return curr;
    }
}
