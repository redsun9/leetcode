package leetcode.leetcode11xx.leetcode1163;

public class Solution {
    public String lastSubstring(String s) {
        int i = 0, j = 1, k = 0, n = s.length();
        char c1, c2;
        while (j + k < n) {
            c1 = s.charAt(i + k);
            c2 = s.charAt(j + k);
            if (c1 == c2) k++;
            else {
                if (c1 > c2) j = j + k + 1;
                else {
                    i = Math.max(i + k + 1, j);
                    j = i + 1;
                }
                k = 0;
            }
        }
        return s.substring(i);
    }
}
