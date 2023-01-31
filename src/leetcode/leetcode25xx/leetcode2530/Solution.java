package leetcode.leetcode25xx.leetcode2530;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) pq.offer(num);

        long ans = 0;
        while (!pq.isEmpty()) {
            if (k == 0) break;
            int poll = pq.poll();
            ans += poll;
            if (poll > 3) pq.offer((poll + 2) / 3);
            k--;
        }
        return ans + k;
    }
}
