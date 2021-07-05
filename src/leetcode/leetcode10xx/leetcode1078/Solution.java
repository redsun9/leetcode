package leetcode.leetcode10xx.leetcode1078;

import java.util.Arrays;

public class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] s = text.split(" ");
        int n = s.length;
        if (n < 3) return new String[0];
        String[] ans = new String[n - 2];
        int ansLength = 0;
        for (int i = 2; i < n; i++) {
            if (s[i - 2].equals(first) && s[i - 1].equals(second)) ans[ansLength++] = s[i];
        }
        return Arrays.copyOf(ans, ansLength);
    }
}
