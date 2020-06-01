package leetcode.leetcode14xx.leetcode1466;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] outcoming = new List[n];
        List<Integer>[] incoming = new List[n];
        for (int[] connection : connections) {
            if (outcoming[connection[0]] == null) outcoming[connection[0]] = new LinkedList<>();
            if (incoming[connection[1]] == null) incoming[connection[1]] = new LinkedList<>();
            outcoming[connection[0]].add(connection[1]);
            incoming[connection[1]].add(connection[0]);
        }
        boolean[] visited = new boolean[n];
        int ans = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            visited[poll] = true;
            if (outcoming[poll] != null) {
                for (Integer neighbour : outcoming[poll]) {
                    if (!visited[neighbour]) {
                        queue.add(neighbour);
                        ans++;
                    }
                }
            }
            if (incoming[poll] != null) {
                for (Integer neighbour : incoming[poll]) {
                    if (!visited[neighbour]) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        return ans;
    }
}
