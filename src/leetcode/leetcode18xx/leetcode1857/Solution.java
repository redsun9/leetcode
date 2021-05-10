package leetcode.leetcode18xx.leetcode1857;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] outgoingNumber = new int[n];
        List<Integer>[] incomingEdges = new List[n];
        List<Integer>[] outgoingEdges = new List[n];
        for (int[] edge : edges) {
            outgoingNumber[edge[0]]++;
            if (incomingEdges[edge[1]] == null) incomingEdges[edge[1]] = new ArrayList<>();
            incomingEdges[edge[1]].add(edge[0]);
            if (outgoingEdges[edge[0]] == null) outgoingEdges[edge[0]] = new ArrayList<>();
            outgoingEdges[edge[0]].add(edge[1]);
        }

        int[][] dpValues = new int[n][26];
        int visited = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (outgoingNumber[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            visited++;
            if (outgoingEdges[node] != null) {
                for (Integer outgoingEdge : outgoingEdges[node]) {
                    for (int i = 0; i < 26; i++)
                        dpValues[node][i] = Math.max(dpValues[node][i], dpValues[outgoingEdge][i]);
                }
            }
            dpValues[node][colors.charAt(node) - 'a']++;
            if (incomingEdges[node] != null)
                for (Integer incomingEdge : incomingEdges[node])
                    if (--outgoingNumber[incomingEdge] == 0) queue.offer(incomingEdge);
        }
        if (visited != n) return -1;
        int ans = 0;
        for (int[] dpValue : dpValues) {
            for (int value : dpValue) {
                ans = Math.max(ans, value);
            }
        }
        return ans;
    }
}
