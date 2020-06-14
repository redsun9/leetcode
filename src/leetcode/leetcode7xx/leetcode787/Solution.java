package leetcode.leetcode7xx.leetcode787;

import java.util.*;

@SuppressWarnings("unchecked")
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) return 0;
        if (K < 0) return -1;
        List<Flight>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new LinkedList<>();
        for (int[] flight : flights) adj[flight[0]].add(new Flight(flight[1], flight[2]));
        int[] prev = new int[n];
        int[] next = new int[n];
        Arrays.fill(prev, Integer.MAX_VALUE);
        prev[src] = 0;
        System.arraycopy(prev, 0, next, 0, n);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        int currentGeneration = 1;
        int nexGeneration = 0;
        while (K >= 0 && !queue.isEmpty()) {
            Integer poll = queue.poll();
            currentGeneration--;
            int curVal = prev[poll];
            for (Flight flight : adj[poll]) {
                if (curVal + flight.price >= next[flight.dest]) continue;
                next[flight.dest] = curVal + flight.price;
                queue.offer(flight.dest);
                nexGeneration++;
            }
            if (currentGeneration == 0) {
                K--;
                currentGeneration = nexGeneration;
                nexGeneration = 0;
                System.arraycopy(next, 0, prev, 0, n);
            }
        }
        return next[dst] != Integer.MAX_VALUE ? next[dst] : -1;
    }

    private static class Flight {
        int dest, price;

        public Flight(int dest, int price) {
            this.dest = dest;
            this.price = price;
        }
    }
}
