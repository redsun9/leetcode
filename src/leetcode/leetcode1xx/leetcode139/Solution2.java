package leetcode.leetcode1xx.leetcode139;

import java.util.List;

public class Solution2 {
    private int[][] child;
    private boolean[] isWord;
    private int nxt = 1, n;
    private boolean[] visited;
    private String s;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.n = s.length();
        this.visited = new boolean[n + 1];
        this.s = s;

        int maxNeeded = 1;
        for (String word : wordDict) maxNeeded += word.length();

        this.child = new int[26][maxNeeded];
        this.isWord = new boolean[maxNeeded];

        int m, c, node;
        for (String word : wordDict) {
            m = word.length();
            node = 0;
            for (int i = 0; i < m; i++) {
                c = word.charAt(i) - 'a';
                if (child[c][node] == 0) child[c][node] = nxt++;
                node = child[c][node];
            }
            isWord[node] = true;
        }
        return dfs(0);
    }

    private boolean dfs(int i) {
        if (visited[i]) return false;
        if (i == n) return true;
        visited[i] = true;
        int node = 0;
        while (i < n) {
            int c = s.charAt(i++) - 'a';
            if (child[c][node] == 0) return false;
            node = child[c][node];
            if (isWord[node] && dfs(i)) return true;
        }
        return false;
    }
}
