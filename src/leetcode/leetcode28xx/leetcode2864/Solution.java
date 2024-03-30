package leetcode.leetcode28xx.leetcode2864;

import java.util.Arrays;

public class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == '1') count++;

        char[] ans = new char[n];
        Arrays.fill(ans, 0, count - 1, '1');
        Arrays.fill(ans, count - 1, n - 1, '0');
        ans[n - 1] = '1';
        return new String(ans);
    }
}
