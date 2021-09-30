package leetcode.leetcode2xx.leetcode291;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        int m = pattern.length(), n = str.length();

        char[] t = pattern.toCharArray();
        char[] s = str.toCharArray();

        int[][] lcp = new int[n + 1][n + 1];
        for (int d = 1; d < n; d++) {
            for (int i = n - 1, j = i - d; j >= 0; i--, j--) {
                if (s[i] == s[j]) lcp[j][i] = lcp[j + 1][i + 1] + 1;
            }
        }

        int[][] mapping = new int[2][26]; // start,len
        Arrays.fill(mapping[0], -1);
        return dfs(0, m, t, 0, n, s, new HashSet<>(), mapping, lcp);
    }

    private static boolean dfs(
            int pos1, int m, char[] t,
            int pos2, int n, char[] s,
            HashSet<String> used, int[][] mapping, int[][] lcp
    ) {
        if (pos1 == m || pos2 == n) return pos1 == m && pos2 == n;
        int c = t[pos1] - 'a';
        if (mapping[0][c] != -1) {
            if (lcp[mapping[0][c]][pos2] < mapping[1][c]) return false;
            return dfs(pos1 + 1, m, t, pos2 + mapping[1][c], n, s, used, mapping, lcp);
        }
        mapping[0][c] = pos2;
        for (int len = 1, end = pos2 + 1; end <= n; len++, end++) {
            String key = new String(s, pos2, len);
            if (used.add(key)) {
                mapping[1][c] = len;
                if (dfs(pos1 + 1, m, t, end, n, s, used, mapping, lcp)) return true;
                used.remove(key);
            }
        }
        mapping[0][c] = -1;
        return false;
    }
}
