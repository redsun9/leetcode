package leetcode.leetcode21xx.leetcode2192;

import java.util.*;

@SuppressWarnings("unchecked")
public class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] incoming = new List[n];
        BitSet[] bitSets = new BitSet[n];
        for (int i = 0; i < n; i++) incoming[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) bitSets[i] = new BitSet(n);
        for (int[] edge : edges) incoming[edge[1]].add(edge[0]);

        List<List<Integer>> ans = new ArrayList<>(n);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            BitSet set = bitSets[i];
            queue.add(i);
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (Integer u : incoming[v]) {
                    if (set.get(u)) continue;
                    set.set(u);
                    queue.offer(u);
                }
            }
            List<Integer> list = new ArrayList<>(set.cardinality());
            for (int j = 0; j < n; j++) if (set.get(j)) list.add(j);
            ans.add(list);
        }
        return ans;
    }
}
