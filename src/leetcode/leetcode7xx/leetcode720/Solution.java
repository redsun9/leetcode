package leetcode.leetcode7xx.leetcode720;

public class Solution {
    public String longestWord(String[] words) {
        if (words.length == 0) return "";
        Trie root = new Trie();
        for (String word : words) root.add(word, 0);
        root.word = "";
        return dfs(root);
    }


    private static String dfs(Trie root) {
        if (root.word == null) return null;
        String ans = root.word;
        if (root.children != null) {
            for (int i = 25; i >= 0; i--) {
                Trie child = root.children[i];
                if (child != null) {
                    String tmp = dfs(child);
                    if (tmp != null && ans.length() <= tmp.length()) ans = tmp;
                }
            }
        }
        return ans;
    }

    private static class Trie {
        String word;
        Trie[] children;

        void add(String word, int i) {
            if (i != word.length()) {
                int c = word.charAt(i) - 'a';
                if (children == null) children = new Trie[26];
                if (children[c] == null) children[c] = new Trie();
                children[c].add(word, i + 1);
            } else {
                this.word = word;
            }
        }
    }
}
