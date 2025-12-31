package leetcode.leetcode37xx.leetcode3781;

import java.util.PriorityQueue;

public class Solution2 {
    @SuppressWarnings("DataFlowIssue")
    public long maximumScore(int[] nums, String s) {
        long ans = 0;
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
            if (s.charAt(i) == '1') ans += pq.poll();
        }
        return ans;
    }
}
