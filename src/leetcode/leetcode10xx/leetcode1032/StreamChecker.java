package leetcode.leetcode10xx.leetcode1032;


import java.util.LinkedList;

public class StreamChecker {
    private final Trie root;
    private LinkedList<Trie> currentState;

    public StreamChecker(String[] words) {
        root = new Trie();
        for (String word : words) {
            root.insert(word);
        }
        currentState = new LinkedList<>();
        currentState.add(root);
    }

    public boolean query(char letter) {
        boolean hasWord = false;
        LinkedList<Trie> nextState = new LinkedList<>();
        for (Trie trie : currentState) {
            if (trie.subTrees != null) {
                Trie subTree = trie.subTrees[letter - 'a'];
                if (subTree != null) {
                    nextState.add(subTree);
                    if (subTree.isWord) hasWord = true;
                }
            }
        }
        nextState.add(root);
        currentState = nextState;
        return hasWord;
    }


    private static class Trie {
        boolean isWord = false;
        private Trie[] subTrees;

        public void insert(String word) {
            char[] chars = word.toCharArray();
            Trie tmp = this;
            for (char aChar : chars) {
                int c = aChar - 'a';
                if (tmp.subTrees == null) tmp.subTrees = new Trie[26];
                if (tmp.subTrees[c] == null) tmp.subTrees[c] = new Trie();
                tmp = tmp.subTrees[c];
            }
            tmp.isWord = true;
        }
    }
}
