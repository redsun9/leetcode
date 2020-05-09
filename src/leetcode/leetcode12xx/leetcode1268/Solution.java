package leetcode.leetcode12xx.leetcode1268;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static final int MAX_NUMBER_OF_SUGGESTIONS = 3;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieHelper root = new TrieHelper();
        for (String s : products) {
            root.addWord(s);
        }
        return root.suggest(searchWord, MAX_NUMBER_OF_SUGGESTIONS);
    }


    private static class TrieHelper {
        private final Trie trie = new Trie();
        private int maxLength;

        public void addWord(String s) {
            int length = s.length();
            maxLength = Math.max(maxLength, length);
            trie.addWord(s, 0, length);
        }

        public List<List<String>> suggest(String s, int suggestions) {
            int n = s.length();
            ArrayList<List<String>> ans = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                ans.add(new LinkedList<>());
            }
            char[] searchStr = s.toCharArray();
            Trie subtree = trie;
            char[] tmp = new char[maxLength];
            for (int i = 0; i < n; i++) {
                if (subtree.tries == null || subtree.tries[searchStr[i] - 'a'] == null) break;
                subtree = subtree.tries[searchStr[i] - 'a'];
                tmp[i] = searchStr[i];
                List<String> list = ans.get(i);
                subtree.suggest(searchStr, i + 1, suggestions, tmp, list);
                if (list.isEmpty()) break;
            }
            return ans;
        }
    }

    private static class Trie {
        private Trie[] tries;
        private boolean isWord;

        private void suggest(char[] s, int idx, int suggestions, char[] tmp, List<String> ans) {
            if (isWord) {
                ans.add(new String(tmp, 0, idx));
            }
            if (tries != null) {
                for (int i = 0; ans.size() < suggestions && i < 26; i++) {
                    if (tries[i] != null) {
                        tmp[idx] = (char) ('a' + i);
                        tries[i].suggest(s, idx + 1, suggestions, tmp, ans);
                    }
                }
            }
        }

        private void addWord(String s, int idx, int length) {
            if (idx == length) isWord = true;
            else {
                if (tries == null) tries = new Trie[26];
                int c = s.charAt(idx) - 'a';
                if (tries[c] == null) tries[c] = new Trie();
                tries[c].addWord(s, idx + 1, length);
            }
        }
    }
}
