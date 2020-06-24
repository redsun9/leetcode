package vtb;

/*
        one swap of chars is acceptible
        return length of the longest substring of the same characters
 */

public class Solution2 {
    public static int longestSubstring(String text) {
        int n = text.length();
        char[] chars = text.toCharArray();
        if (n < 2) return n;
        int[] count = new int[26];
        for (char c : chars) count[c - 'a']++;

        int ans = 0;

        int prePreLen = -1;
        int prePreChar = -1;

        int preLen = 0;
        int preChar = -1;

        int curChar = chars[0] - 'a';
        int curLen = 1;

        for (int i = 1; i < n; i++) {
            if (chars[i] - 'a' == curChar) {
                curLen++;
            } else {
                int tmpLen;
                if (prePreChar == curChar && preLen == 1) {
                    tmpLen = prePreLen + curLen;
                } else {
                    tmpLen = curLen;
                }
                if (tmpLen < count[curChar]) tmpLen++;
                ans = Math.max(ans, tmpLen);
                prePreLen = preLen;
                prePreChar = preChar;
                preLen = curLen;
                preChar = curChar;
                curChar = chars[i] - 'a';
                curLen = 1;
            }
        }
        if (prePreChar == curChar && preLen == 1) {
            int tmpLen = prePreLen + curLen;
            if (tmpLen < count[curChar]) tmpLen++;
            ans = Math.max(ans, tmpLen);
        } else {
            int tmpLen = curLen;
            if (tmpLen < count[curChar]) tmpLen++;
            ans = Math.max(ans, tmpLen);
        }
        return ans;
    }
}
