package leetcode.leetcode23xx.leetcode2301;

@SuppressWarnings("DuplicatedCode")
// wrong solution from discuss
public class WrongSolutionFromDiscuss2 {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        int n = s.length(), m = sub.length();
        boolean[][] map = new boolean[62][62];
        for (char[] mapping : mappings) map[idx(mapping[0])][idx(mapping[1])] = true;
        for (int i = 0; i < 62; i++) map[i][i] = true;

        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = idx(sub.charAt(i));

        int[] lps = lps(b, map);
        int i = 0, j = 0;
        while (i < n) {
            int c = idx(s.charAt(i));
            if (c == b[j] || map[b[j]][c]) {
                i++;
                j++;
                if (j == m) return true;
            } else {
                int originJ = j;
                while (j > 0 && !(b[j] == c || map[b[j]][c])) j = lps[j - 1];
                i = i - (originJ - j) + 1;
            }
        }
        return false;
    }

    private static int[] lps(int[] pat, boolean[][] map) {
        int n = pat.length;
        int[] lps = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            if (pat[i] == pat[j]) {
                lps[i] = lps[i - 1] + 1;
                j++;
                i++;
            } else {
                while (j > 0 && pat[i] != pat[j]) j = lps[j - 1];
                if (pat[i] == pat[j]) lps[i] = lps[i] + 1;
                i++;
            }
        }
        return lps;
    }

    private static int idx(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a';
        if (c >= 'A' && c <= 'Z') return c - 'A' + 26;
        else return c - '0' + 52;
    }
}