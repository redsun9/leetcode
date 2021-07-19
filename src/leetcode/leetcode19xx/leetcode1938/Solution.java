package leetcode.leetcode19xx.leetcode1938;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Solution {
    private static final int MAX_BIT = 17;

    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int n = parents.length, m = queries.length;

        int root = 0;
        List<Integer>[] children = new List[n];
        for (int i = 0; i < n; i++) children[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) root = i;
            else children[parents[i]].add(i);
        }

        List<int[]>[] nodeQueries = new List[n];
        for (int i = 0; i < n; i++) nodeQueries[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) nodeQueries[queries[i][0]].add(new int[]{queries[i][1], i});

        int[] ans = new int[m];
        Trie trie = new Trie(n);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        stack.add(root);

        while (!stack.isEmpty()) {
            Integer node = stack.peekLast();
            if (visited[node]) {
                stack.pollLast();
                trie.add(node, -1);
            } else {
                visited[node] = true;
                trie.add(node, 1);
                for (int[] query : nodeQueries[node]) ans[query[1]] = trie.max(query[0]);
                for (Integer child : children[node]) stack.addLast(child);
            }
        }
        return ans;
    }

    private static class Trie {
        int[][] child;
        int[] count;
        int nxt = 1;

        Trie(int n) {
            child = new int[n * (MAX_BIT + 1) + 1][2];
            count = new int[n * (MAX_BIT + 1) + 1];
        }

        void add(int number, int val) {
            int node = 0;
            for (int i = MAX_BIT; i >= 0; i--) {
                int bit = (number >> i) & 1;
                if (child[node][bit] == 0) child[node][bit] = nxt++;
                node = child[node][bit];
                count[node] += val;
            }
        }

        int max(int number) {
            int node = 0;
            int ans = 0;
            for (int i = MAX_BIT; i >= 0; i--) {
                int bit = (number >> i) & 1;
                if (child[node][bit ^ 1] != 0 && count[child[node][bit ^ 1]] != 0) {
                    node = child[node][bit ^ 1];
                    ans |= (1 << i);
                } else node = child[node][bit];
            }
            return ans;
        }
    }
}
