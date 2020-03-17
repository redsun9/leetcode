package leetcode.leetcode212;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static final int[][] possibleMoves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        if (n == 0) return Collections.emptyList();
        int m = board[0].length;
        if (m == 0) return Collections.emptyList();

        WordTree wordTree = new WordTree();
        for (int i = 0; i < words.length; i++) {
            wordTree.addWord(words[i].toCharArray(), 0, i);
        }
        boolean[][] marked = new boolean[n][m];
        boolean[] found = new boolean[words.length];
        Counter counter = new Counter();
        counter.value = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                find(board, marked, i, j, n, m, wordTree.tree[board[i][j] - 'a'], found, counter);
            }
        }
        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < found.length; i++) {
            if (found[i]) result.add(words[i]);
        }
        return result;
    }

    private static class WordTree {
        private final WordTree[] tree = new WordTree[26];
        private int wordIndex = -1;

        private void addWord(char[] str, int pos, int wordIndex) {
            if (pos == str.length) {
                this.wordIndex = wordIndex;
            } else {
                char c = str[pos];
                WordTree wordTree = tree[c - 'a'];
                if (wordTree == null) {
                    wordTree = new WordTree();
                    tree[c - 'a'] = wordTree;
                }
                wordTree.addWord(str, pos + 1, wordIndex);
            }
        }
    }

    private static void find(char[][] board, boolean[][] marked, int i, int j, int n, int m, WordTree tree, boolean[] result, Counter counter) {
        if (counter.value == 0 || tree == null) return;
        if (tree.wordIndex != -1) {
            result[tree.wordIndex] = true;
            tree.wordIndex = -1;
            counter.value--;
        }
        marked[i][j] = true;
        for (int[] possibleMove : possibleMoves) {
            int newI = i + possibleMove[0];
            int newJ = j + possibleMove[1];
            if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && !marked[newI][newJ]) {
                WordTree newTree = tree.tree[board[newI][newJ] - 'a'];
                find(board, marked, newI, newJ, n, m, newTree, result, counter);
            }
        }
        marked[i][j] = false;
    }

    private static class Counter {
        private int value;
    }
}
