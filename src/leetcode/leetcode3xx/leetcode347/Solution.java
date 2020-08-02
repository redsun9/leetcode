package leetcode.leetcode3xx.leetcode347;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }
        int[] ans = new int[k];
        for (Map.Entry<Integer, Integer> entry : pq) ans[--k] = entry.getKey();
        return ans;
    }
}
