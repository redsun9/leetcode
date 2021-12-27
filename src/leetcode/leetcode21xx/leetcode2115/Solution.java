package leetcode.leetcode21xx.leetcode2115;

import java.util.*;

public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        int[] indegreeCount = new int[n];
        HashMap<String, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> content = ingredients.get(i);
            indegreeCount[i] = content.size();
            for (String s : content) {
                List<Integer> list = adj.computeIfAbsent(s, key -> new ArrayList<>());
                list.add(i);
            }
        }

        List<String> ans = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(supplies));

        while (!queue.isEmpty()) {
            String poll = queue.poll();
            List<Integer> list = adj.get(poll);
            if (list == null) continue;
            for (Integer u : list) {
                if (--indegreeCount[u] == 0) {
                    ans.add(recipes[u]);
                    queue.add(recipes[u]);
                }
            }
        }
        return ans;
    }
}
