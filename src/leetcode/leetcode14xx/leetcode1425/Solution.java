package leetcode.leetcode14xx.leetcode1425;

import java.util.LinkedList;

public class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (k >= n - 1) {
            int ans = 0;
            for (int num : nums) if (num > 0) ans += num;
            if (ans > 0) return ans;
            ans = Integer.MIN_VALUE;
            for (int num : nums) {
                if (num == 0) return 0;
                else ans = Math.max(ans, num);
            }
            return ans;
        } else {
            int ans = nums[0];
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (!queue.isEmpty()) nums[i] += queue.peekFirst();
                ans = Math.max(ans, nums[i]);
                while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                    queue.pollLast();
                }
                if (nums[i] > 0) queue.addLast(nums[i]);
                if (i >= k && !queue.isEmpty() && queue.peekFirst() == nums[i - k]) {
                    queue.pollFirst();
                }
            }
            return ans;
        }
    }
}
