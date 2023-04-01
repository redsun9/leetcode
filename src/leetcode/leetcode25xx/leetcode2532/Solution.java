package leetcode.leetcode25xx.leetcode2532;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        Comparator<int[]> cmp1 = Comparator.comparingInt((int[] x) -> -x[0] - x[2]).thenComparingInt(x -> -x[4]);
        Comparator<int[]> cmp2 = Comparator.comparingInt((int[] x) -> x[5]);
        PriorityQueue<int[]> pq1 = new PriorityQueue<>(cmp1); //left side of bridge
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(cmp1); //right side of bridge
        PriorityQueue<int[]> pq3 = new PriorityQueue<>(cmp2); //getting the old
        PriorityQueue<int[]> pq4 = new PriorityQueue<>(cmp2); //putting the new
        int timeThenBridgeWillBeFree = 0;
        for (int i = 0; i < n; i++) pq1.offer(new int[]{time[i][0], time[i][1], time[i][2], time[i][3], i, 0});
        while (true) {
            // getting to time when bridge is open
            while (!pq3.isEmpty() && pq3.peek()[5] <= timeThenBridgeWillBeFree) pq2.offer(pq3.poll());
            while (!pq4.isEmpty() && pq4.peek()[5] <= timeThenBridgeWillBeFree) pq1.offer(pq4.poll());
            if (!pq2.isEmpty()) {
                int[] tmp = pq2.poll();
                tmp[5] = timeThenBridgeWillBeFree + tmp[2] + tmp[3];
                pq4.offer(tmp);
                timeThenBridgeWillBeFree += tmp[2];
            } else if (!pq1.isEmpty() && n != 0) {
                int[] tmp = pq1.poll();
                tmp[5] = timeThenBridgeWillBeFree + tmp[0] + tmp[1];
                pq3.offer(tmp);
                timeThenBridgeWillBeFree += tmp[0];
                n--;
            } else if (n == 0 && pq3.isEmpty()) {
                return timeThenBridgeWillBeFree;
            } else {
                timeThenBridgeWillBeFree = Integer.MAX_VALUE;
                if (!pq3.isEmpty()) timeThenBridgeWillBeFree = Math.min(timeThenBridgeWillBeFree, pq3.peek()[5]);
                if (!pq4.isEmpty()) timeThenBridgeWillBeFree = Math.min(timeThenBridgeWillBeFree, pq4.peek()[5]);
            }
        }
    }
}
