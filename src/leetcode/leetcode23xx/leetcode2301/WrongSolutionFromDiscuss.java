package leetcode.leetcode23xx.leetcode2301;

@SuppressWarnings("DuplicatedCode")
// wrong solution from discuss
public class WrongSolutionFromDiscuss {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        int n = s.length(), m = sub.length();
        boolean[][] map = new boolean[62][62];
        for (char[] mapping : mappings) map[idx(mapping[0])][idx(mapping[1])] = true;
        for (int i = 0; i < 62; i++) map[i][i] = true;

        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = idx(sub.charAt(i));

        int[] lps = lps(b, map);
        int i = 0, j = 0;
        while (i < n && j < m) {
            int c = idx(s.charAt(i));
            if (c == b[j] || map[b[j]][c]) {
                i++;
                j++;
            } else {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return j == m;
    }

    private static int[] lps(int[] pat, boolean[][] map) {
        int n = pat.length;
        int[] lps = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            if (pat[i] == pat[j] || map[pat[i]][pat[j]] || map[pat[j]][pat[i]]) {
                lps[i] = j + 1;
                j++;
                i++;
            } else {
                boolean found = false;
                for (int c = 0; c < 62; c++) {
                    if (map[pat[i]][c] && map[pat[j]][c]) {
                        found = true;
                        lps[i] = j + 1;
                        j++;
                        i++;
                        break;
                    }
                }
                if (found) continue;

                if (j != 0) j = lps[j - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
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