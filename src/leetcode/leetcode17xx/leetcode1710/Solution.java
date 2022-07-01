package leetcode.leetcode17xx.leetcode1710;

import java.util.Comparator;
import java.util.PriorityQueue;

// Take and then remove if over take
public class Solution {
    @SuppressWarnings("ConstantConditions")
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        int ans = 0;
        for (int[] boxType : boxTypes) {
            ans += boxType[0] * boxType[1];
            truckSize -= boxType[0];
            pq.offer(boxType);
            if (truckSize < 0) {
                int[] poll = null;
                while (truckSize < 0) {
                    poll = pq.poll();
                    truckSize += poll[0];
                    ans -= poll[0] * poll[1];
                }
                int a = Math.min(truckSize, poll[0]);
                if (a > 0) {
                    truckSize -= a;
                    ans += a * poll[1];
                    poll[0] = a;
                    pq.offer(poll);
                }
            }
        }
        return ans;
    }
}
