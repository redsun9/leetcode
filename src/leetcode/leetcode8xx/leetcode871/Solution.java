package leetcode.leetcode8xx.leetcode871;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int ans = 0, i = 0;
        while (startFuel < target) {
            while (i < n && startFuel >= stations[i][0]) pq.offer(stations[i++][1]);
            while (!pq.isEmpty() && startFuel < (i < n ? stations[i][0] : target)) {
                startFuel += pq.poll();
                ans++;
            }
            if (pq.isEmpty() && startFuel < (i < n ? stations[i][0] : target)) return -1;
        }
        return ans;
    }
}
