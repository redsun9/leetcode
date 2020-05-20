package leetcode.leetcode9xx.leetcode924;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        Arrays.sort(initial);
        int n = graph.length;
        int[] colours = new int[n];
        Arrays.fill(colours, -1);
        int[] numberOfInfectedInGroup = new int[initial.length];
        int[] numberOfNodesInGroup = new int[initial.length];
        int colourCounter = 0;
        for (int a : initial) {
            if (colours[a] == -1) {
                numberOfInfectedInGroup[colourCounter]++;
                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(a);
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    if (colours[poll] == -1) {
                        numberOfNodesInGroup[colourCounter]++;
                        colours[poll] = colourCounter;
                        int[] edges = graph[poll];
                        for (int i = 0; i < n; i++) {
                            if (edges[i] == 1 && colours[i] == -1) queue.add(i);
                        }
                    }
                }
                colourCounter++;
            } else {
                numberOfInfectedInGroup[colours[a]]++;
            }
        }

        int max = 0;
        int node = initial[0];
        for (int a : initial) {
            int curColour = colours[a];
            if (
                    numberOfInfectedInGroup[curColour] == 1 && numberOfNodesInGroup[curColour] > max
            ) {
                max = numberOfNodesInGroup[curColour];
                node = a;
            }
        }
        return node;
    }
}
