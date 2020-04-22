package leetcode.leetcode7xx.leetcode797;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        int[] tmp = new int[n];
        tmp[0] = 0;
        List<List<Integer>> ans = new LinkedList<>();
        dfs(graph, n - 1, tmp, 1, ans);
        return ans;
    }

    private static void dfs(
            int[][] graph, int target,
            int[] tmp, int length, List<List<Integer>> ans
    ) {
        int currentNode = tmp[length - 1];
        if (currentNode == target) {
            List<Integer> path = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                path.add(tmp[i]);
            }
            ans.add(path);
            return;
        }
        for (int next : graph[currentNode]) {
            tmp[length] = next;
            dfs(graph, target, tmp, length + 1, ans);
        }
    }
}
