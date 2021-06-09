package leetcode.leetcode16xx.leetcode1696;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x[0]));
        pq.offer(new int[]{nums[0], 0});
        int ans = 0;
        for (int i = 1, j = 1 - k; i < n; i++, j++) {
            while (pq.peek()[1] < j) pq.poll();
            ans = nums[i] + pq.peek()[0];
            if (nums[i] >= 0) pq.clear();
            pq.offer(new int[]{ans, i});
        }
        return ans;
    }
}
