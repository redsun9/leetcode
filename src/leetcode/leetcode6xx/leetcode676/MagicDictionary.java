package leetcode.leetcode6xx.leetcode676;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("ConstantConditions")
public class MagicDictionary {
    private int[][] child;
    private boolean[] isWord;
    private int nxt = 1;

    public void buildDict(String[] dictionary) {
        int maxNeeded = 1;
        for (String s : dictionary) maxNeeded += s.length();

        child = new int[26][maxNeeded];
        isWord = new boolean[maxNeeded];

        for (String s : dictionary) {
            int len = s.length(), node = 0;
            for (int i = 0; i < len; i++) {
                int c = s.charAt(i) - 'a';
                if (child[c][node] == 0) child[c][node] = nxt++;
                node = child[c][node];
            }
            isWord[node] = true;
        }
    }

    public boolean search(String searchWord) {
        int n = searchWord.length();
        Queue<Integer> withError = new ArrayDeque<>();
        int node = 0, nodeWithError;
        for (int i = 0; i < n; i++) {
            int c = searchWord.charAt(i) - 'a';
            int m = withError.size();
            for (int j = 0; j < m; j++) {
                nodeWithError = withError.poll();
                if (child[c][nodeWithError] != 0) withError.add(child[c][nodeWithError]);
            }
            if (node != -1) {
                for (int j = 0; j < 26; j++) if (j != c && child[j][node] != 0) withError.add(child[j][node]);
                if (child[c][node] == 0) node = -1;
                else node = child[c][node];
            }

            if (node == -1 && withError.isEmpty()) return false;
        }
        while (!withError.isEmpty()) if (isWord[withError.poll()]) return true;
        return false;
    }
}
