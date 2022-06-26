package leetcode.leetcode23xx.leetcode2322;

import java.util.*;

@SuppressWarnings("unchecked")
public class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int xorAll = 0;
        for (int num : nums) xorAll ^= num;

        Set<Integer>[] xors = new Set[n];
        boolean[] visited = new boolean[n];
        int[] xorOfSubtree = new int[n];

        int ans = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            Integer u = stack.peek();
            if (!visited[u]) {
                visited[u] = true;
                for (Integer v : adj[u]) if (!visited[v]) stack.push(v);
            } else {
                stack.pop();
                visited[u] = false;
                int xorVal = nums[u];
                for (Integer v : adj[u]) if (!visited[v]) xorVal ^= xorOfSubtree[v];
                xorOfSubtree[u] = xorVal;

                Set<Integer> possibleXor = new HashSet<>();
                //two different subtrees
                for (int v1 : adj[u]) {
                    if (visited[v1]) continue;
                    for (int v2 : adj[u]) {
                        if (v1 == v2 || visited[v2]) continue;
                        for (Integer xor1 : xors[v1]) {
                            for (Integer xor2 : xors[v2]) {
                                int xor3 = xorAll ^ xor1 ^ xor2;
                                ans = Math.min(ans, max(xor1, xor2, xor3) - min(xor1, xor2, xor3));
                            }
                        }
                    }
                }

                // this tree and one subtree
                if (u != 0) {
                    for (int v1 : adj[u]) {
                        if (visited[v1]) continue;
                        for (Integer xor1 : xors[v1]) {
                            int xor2 = xorVal ^ xor1;
                            int xor3 = xorAll ^ xorVal;
                            ans = Math.min(ans, max(xor1, xor2, xor3) - min(xor1, xor2, xor3));
                        }
                        possibleXor.addAll(xors[v1]);
                        xors[v1] = null;
                    }
                }
                possibleXor.add(xorVal);
                xors[u] = possibleXor;
            }
        }
        return ans;
    }


    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
