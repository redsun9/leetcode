package leetcode.leetcode17xx.leetcode1710;

import java.util.Comparator;
import java.util.PriorityQueue;

// Take from pq until enough
public class Solution2 {
    @SuppressWarnings("ConstantConditions")
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x[1]));
        for (int[] boxType : boxTypes) pq.offer(boxType);
        int ans = 0;
        while (!pq.isEmpty() && truckSize > 0) {
            int[] boxType = pq.poll();
            ans += Math.min(truckSize, boxType[0]) * boxType[1];
            truckSize -= boxType[0];
        }
        return ans;
    }
}
