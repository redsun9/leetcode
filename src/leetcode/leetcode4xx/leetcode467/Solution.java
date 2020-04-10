package leetcode.leetcode4xx.leetcode467;

public class Solution {
    public int findSubstringInWraproundString(String p) {
        int length = p.length();
        if (length < 2) return length;
        int[] count = new int[26];
        int currentLength = 1;
        char prevChar = p.charAt(0);
        count[prevChar - 'a'] = 1;
        for (int i = 1; i < length; i++) {
            char c = p.charAt(i);
            if (prevChar + 1 == c || prevChar == 'z' && c == 'a') {
                currentLength++;
            } else {
                currentLength = 1;
            }
            int index = c - 'a';
            count[index] = Math.max(count[index], currentLength);
            prevChar = c;
        }
        int ans = 0;
        for (int a : count) {
            ans += a;
        }
        return ans;
    }
}
