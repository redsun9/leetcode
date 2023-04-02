package leetcode.leetcode25xx.leetcode2558;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("DataFlowIssue")
public class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int gift : gifts) pq.add(gift);
        long ans = 0;
        for (int i = 0; i < k; i++) pq.offer((int) Math.sqrt(pq.poll()));
        while (!pq.isEmpty()) ans += pq.poll();
        return ans;
    }
}
