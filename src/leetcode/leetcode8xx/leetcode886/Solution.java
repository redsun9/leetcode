package leetcode.leetcode8xx.leetcode886;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] colour = new int[n];
        List<Integer>[] neighbors = new List[n];
        for (int[] dislike : dislikes) {
            int u = dislike[0] - 1;
            int v = dislike[1] - 1;
            if (neighbors[u] == null) neighbors[u] = new LinkedList<>();
            if (neighbors[v] == null) neighbors[v] = new LinkedList<>();
            neighbors[u].add(v);
            neighbors[v].add(u);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (colour[i] == 0) {
                int currentColour = 1;
                int currentGeneration = 1;
                int nextGeneration = 0;
                queue.add(i);
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    if (colour[poll] == 0) {
                        colour[poll] = currentColour;
                        if (neighbors[poll] != null) {
                            queue.addAll(neighbors[poll]);
                            nextGeneration += neighbors[poll].size();
                        }
                    } else if (colour[poll] != currentColour) return false;
                    currentGeneration--;
                    if (currentGeneration == 0) {
                        currentColour = 3 - currentColour;
                        currentGeneration = nextGeneration;
                        nextGeneration = 0;
                    }
                }
            }
        }
        return true;
    }
}
