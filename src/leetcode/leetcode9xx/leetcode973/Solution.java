package leetcode.leetcode9xx.leetcode973;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        if (n == k) return points;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x[0] * x[0] - x[1] * x[1]));
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) pq.poll();
        }

        int[][] ans = new int[k][];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
