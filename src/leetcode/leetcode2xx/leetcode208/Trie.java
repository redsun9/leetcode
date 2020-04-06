package leetcode.leetcode2xx.leetcode208;

public class Trie {
    boolean isWord = false;
    private Trie[] subTrees;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        insert(chars, 0, chars.length);
    }

    private void insert(char[] chars, int i, int n) {
        if (i == n) isWord = true;
        else {
            int c = chars[i] - 'a';
            if (subTrees == null) subTrees = new Trie[26];
            if (subTrees[c] == null) subTrees[c] = new Trie();
            subTrees[c].insert(chars, i + 1, n);
        }
    }


    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        return search(chars, 0, chars.length);
    }

    private boolean search(char[] chars, int i, int n) {
        if (i == n) return isWord;
        else {
            int c = chars[i] - 'a';
            if (subTrees == null || subTrees[c] == null) return false;
            return subTrees[c].search(chars, i + 1, n);
        }
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        return startsWith(chars, 0, chars.length);
    }

    private boolean startsWith(char[] chars, int i, int n) {
        if (i == n) {
            return isWord || subTrees != null;
        } else {
            int c = chars[i] - 'a';
            if (subTrees == null || subTrees[c] == null) return false;
            return subTrees[c].startsWith(chars, i + 1, n);
        }
    }
}
