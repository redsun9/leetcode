package leetcode.leetcode37xx.leetcode3781;

import java.util.PriorityQueue;

public class Solution {
    public long maximumScore(int[] nums, String s) {
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') cnt++;
            pq.offer(nums[i]);
            if (pq.size() > cnt) pq.poll();
        }
        long ans = 0;
        while (!pq.isEmpty()) ans += pq.poll();
        return ans;
    }
}
