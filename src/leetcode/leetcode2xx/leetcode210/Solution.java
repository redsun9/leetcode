package leetcode.leetcode2xx.leetcode210;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incomingCount = new int[numCourses];
        List<Integer>[] neighbors = new List[numCourses];
        for (int[] edge : prerequisites) {
            incomingCount[edge[0]]++;
            if (neighbors[edge[1]] == null) neighbors[edge[1]] = new LinkedList<>();
            neighbors[edge[1]].add(edge[0]);
        }
        int[] ans = new int[numCourses];
        int visited = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (incomingCount[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            ans[visited++] = poll;
            if (neighbors[poll] != null)
                for (Integer neighbor : neighbors[poll])
                    if (--incomingCount[neighbor] == 0) queue.offer(neighbor);
        }
        return visited == numCourses ? ans : new int[0];
    }
}
