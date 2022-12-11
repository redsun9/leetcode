package leetcode.leetcode24xx.leetcode2497;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("unchecked")
public class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        PriorityQueue<Integer>[] pqs = new PriorityQueue[n];
        for (int i = 0; i < n; i++) pqs[i] = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            pqs[u].add(vals[v]);
            pqs[v].add(vals[u]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            PriorityQueue<Integer> pq = pqs[i];
            int tmp = vals[i];
            int tmpK = k;
            while (tmpK-- != 0 && !pq.isEmpty() && pq.peek() > 0) tmp += pq.poll();
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}
