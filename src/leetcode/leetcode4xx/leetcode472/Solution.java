package leetcode.leetcode4xx.leetcode472;

import java.util.*;

public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> ans = new LinkedList<>();
        Trie root = new Trie();
        for (String word : words) {
            //check
            if (word.equals("")) continue;
            char[] chars = word.toCharArray();
            HashSet<Trie> prev = new HashSet<>();
            prev.add(root);
            int n = chars.length;
            int i = 0;
            while (i < n && !prev.isEmpty()) {
                int c = chars[i] - 'a';
                HashSet<Trie> next = new HashSet<>();
                for (Trie trie : prev) {
                    if (trie.child != null && trie.child[c] != null) {
                        Trie child = trie.child[c];
                        next.add(child);
                        if (child.isWord) next.add(root);
                    }
                }
                prev = next;
                i++;
            }
            if (prev.contains(root)) ans.add(word);
            else {
                Trie tmp = root;
                for (char c : chars) {
                    int a = c - 'a';
                    if (tmp.child == null) tmp.child = new Trie[26];
                    if (tmp.child[a] == null) tmp.child[a] = new Trie();
                    tmp = tmp.child[a];
                }
                tmp.isWord = true;
            }
        }
        return ans;
    }

    private static class Trie {
        private boolean isWord;
        private Trie[] child;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("{" + isWord + ", [");
            if (child != null) {
                for (int i = 0; i < 26; i++) {
                    if (child[i] != null) sb.append((char) (i + 'a'));
                }
            }
            sb.append("]}");
            return sb.toString();
        }
    }
}
