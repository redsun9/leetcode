package leetcode.leetcode15xx.leetcode1514;

import java.util.*;

@SuppressWarnings({"unchecked"})
public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        if (start == end) return 1;
        List<Pair>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            adj[edge[0]].add(new Pair(edge[1], succProb[i]));
            adj[edge[1]].add(new Pair(edge[0], succProb[i]));
        }
        if (adj[end].isEmpty() || adj[start].isEmpty()) return 0;
        double[] p = new double[n];
        p[start] = 1;
        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingDouble(dest -> -dest.prob));
        pq.offer(new Pair(start, 1));
        while (!pq.isEmpty()) {
            Pair poll = pq.poll();
            if (poll.idx == end) return p[end];
            double currVal = poll.prob;
            if (currVal != p[poll.idx]) continue;
            for (Pair road : adj[poll.idx]) {
                double nextVal = currVal * road.prob;
                if (nextVal > p[road.idx]) {
                    p[road.idx] = nextVal;
                    pq.offer(new Pair(road.idx, nextVal));
                }
            }
        }
        return p[end];
    }

    private record Pair(int idx, double prob) {
    }
}
