package leetcode.leetcode3xx.leetcode310;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new LinkedList<>();
        if (n <= 2) {
            for (int i = 0; i < n; i++) ans.add(i);
            return ans;
        }
        Set<Integer>[] adj = new HashSet[n];
        for (int i = 0; i < n; i++) adj[i] = new HashSet<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        //находим все листья
        List<Integer> prev = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (adj[i].size() == 1) prev.add(i);
        }
        while (n > 2) {
            n = n - prev.size();
            List<Integer> next = new LinkedList<>();
            for (Integer leaf : prev) {
                Integer neighbor = adj[leaf].iterator().next();
                adj[neighbor].remove(leaf);
                if (adj[neighbor].size() == 1) next.add(neighbor);
            }
            prev = next;
        }
        return prev;
    }
}
