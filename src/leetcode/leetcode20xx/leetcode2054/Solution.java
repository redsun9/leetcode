package leetcode.leetcode20xx.leetcode2054;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(x -> x[0]));
        int ans = 0, max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        for (int[] event : events) {
            while (!pq.isEmpty() && pq.peek()[1] < event[0]) max = Math.max(max, pq.poll()[2]);
            ans = Math.max(ans, max + event[2]);
            pq.offer(event);
        }
        return ans;
    }
}
