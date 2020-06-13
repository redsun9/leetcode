package leetcode.leetcode7xx.leetcode785;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colour = new int[n];
        for (int i = 0; i < n; i++) {
            if (colour[i] != 0) continue;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            int curColour = 1;
            int curGeneration = 1;
            int nextGeneration = 0;
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                curGeneration--;
                if (colour[poll] != 0 && colour[poll] != curColour) return false;
                if (colour[poll] == 0) {
                    colour[poll] = curColour;
                    for (int g : graph[poll]) queue.add(g);
                    nextGeneration += graph[poll].length;
                }
                if (curGeneration == 0) {
                    curColour = 3 - curColour;
                    curGeneration = nextGeneration;
                    nextGeneration = 0;
                }
            }
        }
        return true;
    }
}
