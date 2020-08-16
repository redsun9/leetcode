package leetcode.leetcode11xx.leetcode1160;

public class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] reserve = new int[26];
        int n = chars.length();
        for (int i = 0; i < n; i++) reserve[chars.charAt(i) - 'a']++;

        int ans = 0;
        for (String word : words) {
            int m = word.length();
            if (m > n) continue;
            int[] tmp = new int[26];
            boolean ok = true;
            for (int i = 0; i < m; i++) {
                int c = word.charAt(i) - 'a';
                if (tmp[c]++ == reserve[c]) {
                    ok = false;
                    break;
                }
            }
            if (ok) ans += m;
        }
        return ans;
    }
}
