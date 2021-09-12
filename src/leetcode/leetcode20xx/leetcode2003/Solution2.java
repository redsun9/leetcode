package leetcode.leetcode20xx.leetcode2003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    private static final int MAX_VAL = 100_000;

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                index = i;
                break;
            }
        }
        if (index == -1) return ans;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) adj[parents[i]].add(i);

        boolean[] seen = new boolean[MAX_VAL + 2];

        int minMissing = 1;
        while (index != -1) {
            dfs(index, nums, seen, adj);
            while (seen[minMissing]) minMissing++;
            ans[index] = minMissing;
            index = parents[index];
        }
        return ans;
    }

    private static void dfs(int u, int[] nums, boolean[] seen, List<Integer>[] adj) {
        if (!seen[nums[u]]) {
            for (Integer v : adj[u]) dfs(v, nums, seen, adj);
            seen[nums[u]] = true;
        }
    }
}
