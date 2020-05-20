package leetcode.leetcode8xx.leetcode815;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class Solution {
    public int numBusesToDestination(int[][] routes, int start, int end) {
        int n = routes.length;
        HashSet<Integer>[] routeStops = new HashSet[n];
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int stop : routes[i]) {
                set.add(stop);
            }
            routeStops[i] = set;
        }

        boolean[] visited = new boolean[n];
        int currentGeneration = 1;
        int nextGeneration = 0;
        int generationNumber = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer stop = queue.poll();
            if (stop == end) return generationNumber;
            currentGeneration--;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && routeStops[i].contains(stop)) {
                    visited[i] = true;
                    queue.addAll(routeStops[i]);
                    nextGeneration += routeStops[i].size();
                }
            }
            if (currentGeneration == 0) {
                currentGeneration = nextGeneration;
                nextGeneration = 0;
                generationNumber++;
            }
        }
        return -1;
    }
}
