package leetcode.leetcode23xx.leetcode2325;

public class Solution {
    private static final int ALPHABET_SIZE = 26;

    public String decodeMessage(String key, String message) {
        int[] map = new int[ALPHABET_SIZE];
        int cnt = 0, i = 0;
        while (cnt != ALPHABET_SIZE) {
            int c = key.charAt(i++) - 'a';
            if (c >= 0 && c < ALPHABET_SIZE && map[c] == 0) map[c] = ++cnt;
        }
        char[] ans = message.toCharArray();
        int n = ans.length;
        for (int j = 0; j < n; j++) {
            int c = ans[j] - 'a';
            if (c >= 0 && c < ALPHABET_SIZE) ans[j] = (char) (map[c] + 'a' - 1);
        }
        return new String(ans);
    }
}
