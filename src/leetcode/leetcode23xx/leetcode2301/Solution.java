package leetcode.leetcode23xx.leetcode2301;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        boolean[][] map = new boolean[62][62];
        for (char[] mapping : mappings) map[idx(mapping[0])][idx(mapping[1])] = true;
        for (int i = 0; i < 62; i++) map[i][i] = true;
        int n = s.length(), m = sub.length();
        char[] a = s.toCharArray(), b = sub.toCharArray();
        for (int l = 0, r = m; r <= n; l++, r++) {
            boolean ok = true;
            for (int i1 = l, i2 = 0; ok && i2 < m; i1++, i2++) ok = map[idx(b[i2])][idx(a[i1])];
            if (ok) return true;
        }
        return false;
    }

    private static int idx(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a';
        if (c >= 'A' && c <= 'Z') return c - 'A' + 26;
        else return c - '0' + 52;
    }
}
