package leetcode.leetcode2xx.leetcode207;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] edges = new LinkedList[numCourses];
        for (int[] prerequisite : prerequisites) {
            if (prerequisite[0] == prerequisite[1]) return false;
            if (edges[prerequisite[0]] == null) edges[prerequisite[0]] = new LinkedList<>();
            edges[prerequisite[0]].add(prerequisite[1]);
        }
        boolean[] seen = new boolean[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (edges[i] != null) {
                Arrays.fill(seen, false);
                queue.addAll(edges[i]);
                while (!queue.isEmpty()) {
                    int poll = queue.poll();
                    if (poll == i) return false;
                    if (!seen[poll]) {
                        seen[poll] = true;
                        if (edges[poll] != null) {
                            queue.addAll(edges[poll]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
