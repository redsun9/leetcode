package leetcode.leetcode10xx.leetcode1029;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> costs[x][0] - costs[x][1]));
        for (int i = 0; i < n; i++) pq.offer(i);
        int ans = 0;
        for (int i = n / 2; i > 0; i--) {
            ans += costs[pq.poll()][0];
        }
        for (int i = n / 2; i > 0; i--) {
            ans += costs[pq.poll()][1];
        }
        return ans;
    }
}
