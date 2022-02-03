package leetcode.leetcode21xx.leetcode2140;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x[0]));
        pq.offer(new long[]{-1, 0});
        long max = 0, curr;
        for (int i = 0; i < n; i++) {
            int[] question = questions[i];
            while (!pq.isEmpty() && pq.peek()[0] < i) max = Math.max(max, pq.poll()[1]);
            pq.offer(new long[]{i + question[1], max + question[0]});
        }
        long ans = 0;
        while (!pq.isEmpty()) ans = Math.max(ans, pq.poll()[1]);
        return ans;
    }
}
