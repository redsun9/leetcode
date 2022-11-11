package leetcode.leetcode24xx.leetcode2462;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("DataFlowIssue")
public class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] x) -> x[0]).thenComparingInt(x -> x[1]));
        for (int i = 0; i < candidates; i++) pq.offer(new int[]{costs[i], i});
        for (int i = Math.max(candidates, n - candidates); i < n; i++) pq.offer(new int[]{costs[i], i});
        long ans = 0;
        for (int i = 0, l = candidates, r = n - 1 - candidates; i < k; i++) {
            int[] poll = pq.poll();
            ans += poll[0];
            if (poll[1] < l) {
                if (l <= r) pq.offer(new int[]{costs[l], l});
                l++;
            }
            if (poll[1] > r) {
                if (l <= r) pq.offer(new int[]{costs[r], r});
                r--;
            }
        }
        return ans;
    }
}
