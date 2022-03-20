package leetcode.leetcode22xx.leetcode2203;

import java.util.*;

@SuppressWarnings("unchecked")
public class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<int[]>[] incoming = new List[n], outcoming = new List[n];
        for (int i = 0; i < n; i++) {
            incoming[i] = new ArrayList<>();
            outcoming[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            outcoming[edge[0]].add(edge);
            incoming[edge[1]].add(edge);
        }

        long[] dist1 = new long[n], dist2 = new long[n], dist3 = new long[n];
        Arrays.fill(dist1, Long.MAX_VALUE);
        dist1[src1] = 0;
        Arrays.fill(dist2, Long.MAX_VALUE);
        dist2[src2] = 0;
        Arrays.fill(dist3, Long.MAX_VALUE);
        dist3[dest] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x.dist));
        pq.offer(new Node(src1, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            long dist = node.dist;
            int u = node.idx;
            if (dist1[u] != dist) continue;
            for (int[] edge : outcoming[u]) {
                long testDist = dist + edge[2];
                int v = edge[1];
                if (dist1[v] > testDist) {
                    dist1[v] = testDist;
                    pq.offer(new Node(v, testDist));
                }
            }
        }

        pq.offer(new Node(src2, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            long dist = node.dist;
            int u = node.idx;
            if (dist2[u] != dist) continue;
            for (int[] edge : outcoming[u]) {
                long testDist = dist + edge[2];
                int v = edge[1];
                if (dist2[v] > testDist) {
                    dist2[v] = testDist;
                    pq.offer(new Node(v, testDist));
                }
            }
        }

        pq.offer(new Node(dest, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            long dist = node.dist;
            int v = node.idx;
            if (dist3[v] != dist) continue;
            for (int[] edge : incoming[v]) {
                long testDist = dist + edge[2];
                int u = edge[0];
                if (dist3[u] > testDist) {
                    dist3[u] = testDist;
                    pq.offer(new Node(u, testDist));
                }
            }
        }


        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist1[i] == Long.MAX_VALUE || dist2[i] == Long.MAX_VALUE || dist3[i] == Long.MAX_VALUE) continue;
            ans = Math.min(ans, dist1[i] + dist2[i] + dist3[i]);
        }
        return ans == Long.MAX_VALUE ? -1 : ans;
    }


    private record Node(int idx, long dist) {
    }
}
