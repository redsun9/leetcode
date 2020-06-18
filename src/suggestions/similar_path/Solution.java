package suggestions.similar_path;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/*
        Given an undirected graph represented by it's edges.
        Find the most similar path in this graph.
        The most similar graph - from all possible paths it has minimum editing distance from target,
        if there are many paths with the same editing distance from target choose any of them

        n - number of vertices in the graph.
        vertices are labeled 0..n-1
        edges[i].length = 2
        0 <= edges[i][0] < n
        0 <= edges[i][1] < n
 */

public class Solution {
    public int[] similarPath(int n, int[][] edges, int[] target) {
        int m = target.length;
        if (n == 0 || m == 0) return new int[0];
        if (edges.length == 0) {
            //should return any existing node in target
            for (int t : target) {
                if (t >= 0 && t < n) {
                    return new int[]{t};
                }
            }
            return new int[0];
        }

        boolean foundAny = false;
        for (int t : target) {
            if (t >= 0 && t < n) {
                foundAny = true;
                break;
            }
        }
        if (!foundAny) return new int[0];

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new LinkedList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        for (List<Integer> list : adj) Collections.sort(list);

        int[][] dp = new int[m + 1][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int min = dp[i + 1][j];
                for (Integer neighbor : adj[j]) min = Math.min(min, dp[i + 1][neighbor]);
                dp[i][j] = min + (target[i] == j ? 0 : 1);
            }
        }
        int curNode = 0;
        int curVal = dp[0][0];
        for (int i = 0; i < n; i++) {
            if (dp[0][i] < curVal) {
                curNode = i;
                curVal = dp[0][i];
            }
        }

        int[] ans = new int[m];
        ans[0] = curNode;
        for (int i = 1; i < m; i++) {
            int min = Integer.MAX_VALUE;
            int nextNode = -1;
            for (Integer neighbour : adj[curNode]) {
                if (dp[i][neighbour] < min) {
                    min = dp[i][neighbour];
                    nextNode = neighbour;
                }
            }
            ans[i] = nextNode;
            curNode = nextNode;
        }
        return ans;
    }
}
