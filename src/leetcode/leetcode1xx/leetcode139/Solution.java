package leetcode.leetcode1xx.leetcode139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        if (n == 0) return true;
        if (wordDict.isEmpty()) return false;

        Trie root = new Trie();
        for (String word : wordDict) {
            if (word.length() < n) {
                root.insert(word);
            } else if (word.length() == n) {
                if (s.equals(word)) return true;
            }
        }
        if (root.subTrees == null) return false;

        Set<Trie> prev = new HashSet<>();
        prev.add(root);
        for (int i = 0; i < n && !prev.isEmpty(); i++) {
            int c = s.charAt(i) - 'a';
            Set<Trie> current = new HashSet<>();
            for (Trie trie : prev) {
                if (trie.subTrees[c] != null) {
                    trie = trie.subTrees[c];
                    if (trie.isWord) current.add(root);
                    if (trie.subTrees != null) current.add(trie);
                }
            }
            prev = current;
        }
        return prev.contains(root);
    }

    private static class Trie {
        boolean isWord = false;
        private Trie[] subTrees;

        public void insert(String word) {
            Trie tmp = this;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                int c = word.charAt(i) - 'a';
                if (tmp.subTrees == null) tmp.subTrees = new Trie[26];
                if (tmp.subTrees[c] == null) tmp.subTrees[c] = new Trie();
                tmp = tmp.subTrees[c];
            }
            tmp.isWord = true;
        }
    }
}
