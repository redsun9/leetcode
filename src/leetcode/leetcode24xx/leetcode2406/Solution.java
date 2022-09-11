package leetcode.leetcode24xx.leetcode2406;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) return n;
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        int ans = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        for (int[] interval : intervals) {
            int threshold = interval[0];
            while (!pq.isEmpty() && pq.peek()[1] < threshold) pq.poll();
            pq.offer(interval);
            ans = Math.max(ans, pq.size());
        }
        return ans;
    }
}
