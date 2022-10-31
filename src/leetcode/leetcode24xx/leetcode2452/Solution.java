package leetcode.leetcode24xx.leetcode2452;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int m = dictionary.length, n = dictionary[0].length();
        Trie trie = new Trie(1 + m * n, n);
        for (String s : dictionary) trie.addString(s);
        List<String> ans = new ArrayList<>();
        for (String query : queries) if (trie.contains(query)) ans.add(query);
        return ans;
    }

    @SuppressWarnings("DuplicatedCode")
    private static class Trie {
        final int[][] child;
        final int n;
        int nxt = 1;

        public Trie(int max, int n) {
            child = new int[max][26];
            this.n = n;
        }

        public void addString(String str) {
            int node = 0;
            for (int i = 0; i < n; i++) {
                int c = str.charAt(i) - 'a';
                if (child[node][c] == 0) child[node][c] = nxt++;
                node = child[node][c];
            }
        }

        public boolean contains(String str) {
            return contains(str, 0, 0, 2);
        }

        private boolean contains(String s, int node, int i, int k) {
            if (k == -1) return false;
            if (i == n) return true;
            int c1 = s.charAt(i) - 'a';
            for (int c2 = 0; c2 < 26; c2++) {
                int nextNode = child[node][c2];
                if (nextNode == 0) continue;
                if (c1 == c2 && contains(s, nextNode, i + 1, k)) return true;
                else if (contains(s, nextNode, i + 1, k - 1)) return true;
            }
            return false;
        }
    }
}

