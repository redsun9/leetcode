package leetcode.leetcode23xx.leetcode2306;

public class Solution {
    public long distinctNames(String[] ideas) {
        int n = ideas.length;
        int maxRequired = 1;
        for (String idea : ideas) maxRequired += idea.length();
        int[][] child = new int[26][maxRequired];
        boolean[] isWord = new boolean[maxRequired];
        int nxt = 1;

        int[] preFirstNodes = new int[n];
        for (int j = 0; j < n; j++) {
            String idea = ideas[j];
            int node = 0;
            for (int i = idea.length() - 1; i > 0; i--) {
                int c = idea.charAt(i) - 'a';
                if (child[c][node] == 0) child[c][node] = nxt++;
                node = child[c][node];
            }
            preFirstNodes[j] = node;
            int c = idea.charAt(0) - 'a';
            if (child[c][node] == 0) child[c][node] = nxt++;
            node = child[c][node];
            isWord[node] = true;
        }
        int[][] cnt = new int[26][26];

        for (int i = 0; i < n; i++) {
            int node = preFirstNodes[i];
            int lastChar = ideas[i].charAt(0) - 'a';
            for (int c = 0; c < 26; c++) {
                if (child[c][node] == 0 || !isWord[child[c][node]]) cnt[lastChar][c]++;
            }
        }

        long ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j) continue;
                ans += (long) cnt[i][j] * cnt[j][i];
            }
        }
        return ans;
    }
}
