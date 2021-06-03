package leetcode.leetcode16xx.leetcode1684;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] b = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) b[allowed.charAt(i) - 'a'] = true;
        int ans = 0;
        for (String word : words) {
            boolean ok = true;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                if (!b[word.charAt(i) - 'a']) {
                    ok = false;
                    break;
                }
            }
            if (ok) ans++;
        }
        return ans;
    }
}
