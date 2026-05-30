package leetcode.leetcode39xx.leetcode3939;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    private static final int p = 1_000_000_007;

    public int countValidSubsets(int[] parent, int[] nums, int k) {
        int n = parent.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) if (parent[i] != -1) adj[parent[i]].add(i);

        boolean[] visited = new boolean[n];
        long[][] dpA = new long[n][], dpB = new long[n][];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        while (!stack.isEmpty()) {
            int u = stack.peek();
            if (!visited[u]) {
                stack.addAll(adj[u]);
                visited[u] = true;
            } else {
                stack.pop();

                long[] tmpA = new long[k], tmpB = new long[k], tmp = new long[k], swap;
                tmpA[0] = 1;
                tmpB[0] = 1;

                for (Integer v : adj[u]) {
                    // tmpA = tmpA combine child.b
                    Arrays.fill(tmp, 0);
                    for (int i = 0; i < k; i++) {
                        for (int j = 0; j < k; j++) {
                            int ij = (i + j) % k;
                            tmp[ij] += tmpA[i] * dpB[v][j];
                            if (tmp[ij] >= p) tmp[ij] %= p;
                        }
                    }
                    swap = tmpA;
                    tmpA = tmp;
                    tmp = swap;

                    // tmpB = tmpB combine (child.a, child.b)
                    Arrays.fill(tmp, 0);
                    for (int i = 0; i < k; i++) {
                        for (int j = 0; j < k; j++) {
                            int ij = (i + j) % k;
                            tmp[ij] += tmpB[i] * (dpA[v][j] + dpB[v][j]);
                            if (tmp[ij] >= p) tmp[ij] %= p;
                        }
                    }
                    swap = tmpB;
                    tmpB = tmp;
                    tmp = swap;
                }

                // shift tmpA by nums[u]
                dpA[u] = new long[k];
                for (int i = 0; i < k; i++) {
                    dpA[u][(i + nums[u]) % k] = tmpA[i];
                }
                dpB[u] = tmpB;
            }
        }

        return (int) ((dpA[0][0] + dpB[0][0] - 1) % p);
    }
}
