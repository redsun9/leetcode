package leetcode.leetcode18xx.leetcode1839;

public class Solution {
    public int longestBeautifulSubstring(String word) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int ans = 0, left = 0, right = -1, position = -1, n = word.length();
        while (++right < n) {
            char c = word.charAt(right);
            if (position < 4 && c == vowels[position + 1]) {
                position++;
                if (position == 0) left = right;
            }
            if (position >= 0 && c != vowels[position]) {
                left = right;
                position = c == 'a' ? 0 : -1;
            }
            if (position == 4) ans = Math.max(ans, right - left + 1);
        }
        return ans;

    }
}
