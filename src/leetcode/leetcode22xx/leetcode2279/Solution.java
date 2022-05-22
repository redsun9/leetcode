package leetcode.leetcode22xx.leetcode2279;

import java.util.PriorityQueue;

public class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) pq.add(capacity[i] - rocks[i]);
        int ans = 0;
        while (!pq.isEmpty() && additionalRocks >= pq.peek()) {
            additionalRocks -= pq.poll();
            ans++;
        }
        return ans;
    }
}
