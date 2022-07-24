package leetcode.leetcode23xx.leetcode2352;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

// trie-based solution
public class Solution2 {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<TrieNode, Integer> cnt = new IdentityHashMap<>();
        TrieNode root = new TrieNode();

        for (int[] row : grid) {
            TrieNode node = root;
            for (int val : row) {
                if (node.children == null) node.children = new HashMap<>();
                TrieNode nxtNode = node.children.get(val);
                if (nxtNode == null) {
                    nxtNode = new TrieNode();
                    node.children.put(val, nxtNode);
                }
                node = nxtNode;
            }
            cnt.compute(node, (k, v) -> v == null ? 1 : v + 1);
        }

        int ans = 0;
        for (int j = 0; j < n; j++) {
            TrieNode node = root;
            for (int[] row : grid) {
                node = node.children.get(row[j]);
                if (node == null) break;
            }
            if (node != null) ans += cnt.get(node);
        }
        return ans;
    }


    private static class TrieNode {
        Map<Integer, TrieNode> children;
    }
}
