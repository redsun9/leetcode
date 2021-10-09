package leetcode.leetcode4xx.leetcode444;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Solution {
    /**
     * @param org:  a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        int n = org.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        int[] indegree = new int[n];
        boolean atLeastOne = false;
        for (int[] seq : seqs) {
            int m = seq.length;
            if (m == 0) continue;
            atLeastOne = true;
            if (seq[0] <= 0 || seq[0] > n) return false;
            for (int i = 1; i < m; i++) {
                int u = seq[i - 1] - 1;
                int v = seq[i] - 1;
                if (v < 0 || v >= n) return false;
                adj[u].add(v);
                indegree[v]++;
            }
        }

        if (n == 0) return true;
        if (n == 1) return atLeastOne;

        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (prev != -1) return false;
                prev = i;
            }
        }
        if (prev != org[0] - 1) return false;
        int curLen = 1;
        while (curLen != n) {
            int next = -1;
            for (Integer v : adj[prev]) {
                if (--indegree[v] == 0) {
                    if (next != -1) return false;
                    next = v;
                }
            }
            if (next != org[curLen] - 1) return false;
            prev = next;
            curLen++;
        }
        return true;
    }
}
