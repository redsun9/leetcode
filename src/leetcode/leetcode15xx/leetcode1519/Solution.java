package leetcode.leetcode15xx.leetcode1519;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] neighbours = new List[n];
        for (int i = 0; i < n; i++) neighbours[i] = new LinkedList<>();
        for (int[] edge : edges) {
            neighbours[edge[0]].add(edge[1]);
            neighbours[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int[] ans = new int[n];
        dfs(0, neighbours, labels, visited, ans);
        return ans;
    }

    private static int[] dfs(int current, List<Integer>[] neighbours, String labels, boolean[] visited, int[] ans) {
        int[] tmp = new int[26];
        visited[current] = true;
        for (Integer neighbour : neighbours[current]) {
            if (!visited[neighbour]) {
                int[] sub = dfs(neighbour, neighbours, labels, visited, ans);
                for (int i = 0; i < 26; i++) {
                    tmp[i] += sub[i];
                }
            }
        }
        int currChar = labels.charAt(current) - 'a';
        tmp[currChar]++;
        ans[current] = tmp[currChar];
        return tmp;
    }
}
