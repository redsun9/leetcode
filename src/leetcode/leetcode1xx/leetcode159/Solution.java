package leetcode.leetcode1xx.leetcode159;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        char a = ' ', b = ' ';
        int lastA = -1, lastB = -1, start = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == a) lastA = i;
            else if (c == b) lastB = i;
            else {
                if (lastA > lastB) {
                    start = lastB + 1;
                    lastB = i;
                    b = c;
                } else {
                    start = lastA + 1;
                    lastA = i;
                    a = c;
                }
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
