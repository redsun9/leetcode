package leetcode.leetcode22xx.leetcode2246;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"DuplicatedCode", "unchecked"})
public class Solution {
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] children = new List[n];
        for (int i = 0; i < n; i++) children[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) children[parent[i]].add(i);

        int[] dp = new int[n];
        boolean[] visited = new boolean[n];
        int ans = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        while (!stack.isEmpty()) {
            int u = stack.peekLast();
            if (!visited[u]) {
                visited[u] = true;
                stack.addAll(children[u]);
            } else {
                stack.removeLast();
                int max1 = 0, max2 = 0;
                for (int v : children[u]) {
                    if (s.charAt(u) == s.charAt(v)) continue;
                    if (dp[v] > max1) {
                        max2 = max1;
                        max1 = dp[v];
                    } else if (dp[v] > max2) max2 = dp[v];
                }
                ans = Math.max(ans, max1 + max2 + 1);
                dp[u] = max1 + 1;
            }
        }
        return ans;
    }
}
