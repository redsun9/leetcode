package leetcode.leetcode25xx.leetcode2538;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        long[][][] maxPaths = new long[n][][];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, -1});
        while (!stack.isEmpty()) {
            int[] poll = stack.peek();
            int node = poll[0], parent = poll[1];
            if (maxPaths[node] == null) {
                maxPaths[node] = new long[2][];
                maxPaths[node][0] = new long[]{price[node], -1};
                maxPaths[node][1] = new long[]{price[node], -1};
                for (int child : adj[node]) if (child != parent) stack.push(new int[]{child, node});
            } else {
                stack.pop();
                for (int child : adj[node]) {
                    if (child != parent) {
                        long tmpValue = maxPaths[child][0][0] + price[node];
                        if (tmpValue > maxPaths[node][0][0]) {
                            maxPaths[node][1][0] = maxPaths[node][0][0];
                            maxPaths[node][1][1] = maxPaths[node][0][1];
                            maxPaths[node][0][0] = tmpValue;
                            maxPaths[node][0][1] = child;
                        } else if (tmpValue > maxPaths[node][1][0]) {
                            maxPaths[node][1][0] = tmpValue;
                            maxPaths[node][1][1] = child;
                        }
                    }
                }
            }
        }
        stack.push(new int[]{0, -1});
        while (!stack.isEmpty()) {
            int[] poll = stack.pop();
            int node = poll[0], parent = poll[1];
            if (parent != -1) {
                for (long[] parentMax : maxPaths[parent]) {
                    if (parentMax[1] == node) continue;
                    long tmpValue = parentMax[0] + price[node];
                    if (tmpValue > maxPaths[node][0][0]) {
                        maxPaths[node][1][0] = maxPaths[node][0][0];
                        maxPaths[node][1][1] = maxPaths[node][0][1];
                        maxPaths[node][0][0] = tmpValue;
                        maxPaths[node][0][1] = parent;
                    } else if (tmpValue > maxPaths[node][1][0]) {
                        maxPaths[node][1][0] = tmpValue;
                        maxPaths[node][1][1] = parent;
                    }
                }
            }
            for (int child : adj[node]) if (child != parent) stack.push(new int[]{child, node});
        }
        long ans = 0;
        for (int i = 0; i < n; i++) ans = Math.max(ans, maxPaths[i][0][0] - price[i]);
        return ans;
    }
}
