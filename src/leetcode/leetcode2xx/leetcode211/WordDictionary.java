package leetcode.leetcode2xx.leetcode211;

public class WordDictionary {
    private static final int MAX_WORD_LENGTH = 500;
    private final Trie[] roots = new Trie[MAX_WORD_LENGTH + 1];

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        int length = word.length();
        if (roots[length] == null) roots[length] = new Trie();
        Trie root = roots[length];
        for (int i = 0; i < length; i++) {
            int c = word.charAt(i) - 'a';
            if (root.children == null) root.children = new Trie[26];
            if (root.children[c] == null) root.children[c] = new Trie();
            root = root.children[c];
        }
        root.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        int length = word.length();
        if (roots[length] == null) return false;
        return search(roots[length], word, 0, length);
    }

    private static boolean search(Trie root, String word, int pos, int length) {
        if (pos == length) return root.isWord;
        if (root.children == null) return false;
        if (word.charAt(pos) != '.') {
            int c = word.charAt(pos) - 'a';
            if (root.children[c] == null) return false;
            return search(root.children[c], word, pos + 1, length);
        } else {
            for (Trie child : root.children) {
                if (child != null && search(child, word, pos + 1, length)) return true;
            }
            return false;
        }
    }

    private static class Trie {
        boolean isWord;
        Trie[] children;
    }
}
