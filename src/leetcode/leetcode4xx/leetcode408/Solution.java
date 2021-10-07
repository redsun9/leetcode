package leetcode.leetcode4xx.leetcode408;

public class Solution {
    /**
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length(), n = abbr.length();
        if (m < n) return false;

        int i = 0, j = 0;
        while (i < m && j < n) {
            char c = abbr.charAt(j++);
            if (c == '0') return false;
            else if (c >= '1' && c <= '9') {
                int count = c - '0';
                while (j < n) {
                    c = abbr.charAt(j);
                    if (c < '0' || c > '9') break;
                    count = count * 10 + c - '0';
                    j++;
                }
                if (i + count > m) return false;
                i += count;
            } else if (word.charAt(i++) != c) return false;
        }
        return i == m && j == n;
    }
}
