package leetcode.leetcode16xx.leetcode1637;

import java.util.PriorityQueue;

public class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        if (points.length <= 1) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] point : points) pq.offer(point[0]);
        int ans = 0;
        Integer prev = pq.poll(), next;
        for (int i = pq.size(); i > 0; i--) {
            next = pq.poll();
            ans = Math.max(ans, next - prev);
            prev = next;
        }
        return ans;
    }
}
