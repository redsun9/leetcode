package leetcode.leetcode4xx.leetcode425;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private int n;
    private int[][] child;
    private int[] wordIndex;
    private String[] words;
    private List<List<String>> ans;

    /**
     * @param words: a set of words without duplicates
     * @return all word squares
     */
    public List<List<String>> wordSquares(String[] words) {
        if (words.length == 0) return Collections.emptyList();
        this.words = words;
        this.n = words[0].length();

        int m = words.length;
        int maxNeeded = m * n + 1, nxt = 1;
        this.child = new int[maxNeeded][26];
        this.wordIndex = new int[maxNeeded];

        for (int i = 0; i < m; i++) {
            String word = words[i];
            int node = 0;
            for (int j = 0; j < n; j++) {
                int c = word.charAt(j) - 'a';
                if (child[node][c] == 0) child[node][c] = nxt++;
                node = child[node][c];
            }
            wordIndex[node] = i;
        }
        this.ans = new ArrayList<>();
        dfs(0, 0, new int[n]);
        return ans;
    }

    private void dfs(int i, int j, int[] tmp) {
        if (i == n) {
            List<String> list = new ArrayList<>(n);
            for (int k = 0; k < n; k++) list.add(words[wordIndex[tmp[k]]]);
            ans.add(list);
            return;
        }
        if (i == j) {
            int prevVal = tmp[i];
            for (int c = 0; c < 26; c++) {
                if (child[prevVal][c] != 0) {
                    tmp[i] = child[prevVal][c];
                    dfs(i + 1, 0, tmp);
                }
            }
            tmp[i] = prevVal;
        } else {
            int prevVal1 = tmp[i];
            int prevVal2 = tmp[j];
            for (int c = 0; c < 26; c++) {
                if (child[prevVal1][c] != 0 && child[prevVal2][c] != 0) {
                    tmp[i] = child[prevVal1][c];
                    tmp[j] = child[prevVal2][c];
                    dfs(i, j + 1, tmp);
                }
            }
            tmp[i] = prevVal1;
            tmp[j] = prevVal2;
        }
    }
}
