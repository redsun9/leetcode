package leetcode.leetcode15xx.leetcode1514;

import java.util.*;

@SuppressWarnings("unchecked")
public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        if (start == end) return 1;
        List<Pair>[] neighbours = new List[n];
        for (int i = 0; i < n; i++) neighbours[i] = new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            neighbours[edge[0]].add(new Pair(edge[1], succProb[i]));
            neighbours[edge[1]].add(new Pair(edge[0], succProb[i]));
        }
        if (neighbours[end].isEmpty()) return 0;
        double[] probs = new double[n];
        probs[start] = 1;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(ind -> -probs[ind]));
        pq.offer(start);
        while (!pq.isEmpty()) {
            Integer poll = pq.poll();
            if (poll == end) return probs[end];
            double currVal = probs[poll];
            for (Pair pair : neighbours[poll]) {
                double nextVal = currVal * pair.prob;
                if (nextVal > probs[pair.dest]) {
                    if (probs[pair.dest] != 0) pq.remove(pair.dest);
                    probs[pair.dest] = nextVal;
                    pq.offer(pair.dest);
                }
            }
        }
        return probs[end];
    }

    private static class Pair {
        private final int dest;
        private final double prob;

        public Pair(int dest, double prob) {
            this.dest = dest;
            this.prob = prob;
        }
    }
}
