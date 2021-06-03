package leetcode.leetcode0xx.leetcode43;

public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        char[] ans = new char[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                ans[i + j + 1] += a * (num2.charAt(j) - '0');
            }
        }
        int pos = m + n - 1;
        int overflow = 0;
        for (int i = m + n - 1; i >= 0; i--) {
            overflow += ans[i];
            if (overflow != 0) pos = i;
            ans[i] = (char) ('0' + overflow % 10);
            overflow = overflow / 10;
        }
        return new String(ans, pos, m + n - pos);
    }
}
