package leetcode.leetcode7xx.leetcode703;

import java.util.PriorityQueue;

public class KthLargest {
    private final PriorityQueue<Integer> pq;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>(k + 1);
        this.k = k;
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}
