package leetcode.leetcode8xx.leetcode834;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<Integer>[] neighbours = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            neighbours[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            neighbours[edge[0]].add(edge[1]);
            neighbours[edge[1]].add(edge[0]);
        }
        int[] childrenNumber = new int[n];
        int[] ans = new int[n];
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        while (!stack.isEmpty()) {
            Integer peek = stack.peek();
            if (visited[peek]) {
                visited[peek] = false;
                for (Integer neighbour : neighbours[peek]) {
                    if (!visited[neighbour]) {
                        childrenNumber[peek] += childrenNumber[neighbour] + 1;
                        ans[peek] += ans[neighbour] + childrenNumber[neighbour] + 1;
                    }
                }
                stack.pop();
            } else {
                visited[peek] = true;
                for (Integer neighbour : neighbours[peek]) {
                    if (!visited[neighbour]) stack.push(neighbour);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            visited[poll] = true;
            for (Integer neighbour : neighbours[poll]) {
                if (visited[neighbour]) {
                    ans[poll] += (ans[neighbour] - ans[poll] - childrenNumber[poll] - 1) + (childrenNumber[neighbour] - childrenNumber[poll]);
                    childrenNumber[poll] = n - 1;
                } else {
                    queue.add(neighbour);
                }
            }
        }
        return ans;
    }
}
