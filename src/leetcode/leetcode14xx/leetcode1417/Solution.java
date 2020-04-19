package leetcode.leetcode14xx.leetcode1417;

public class Solution {
    public String reformat(String s) {
        int n = s.length();
        if (n < 2) return s;
        int digitNumber = 0;
        int alphaNumber = 0;
        int[] digits = new int[10];
        int[] alphas = new int[26];
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                digitNumber++;
                digits[c - '0']++;
            } else {
                alphaNumber++;
                alphas[c - 'a']++;
            }
        }
        if (Math.abs(digitNumber - alphaNumber) > 1) return "";
        char[] ans = new char[n];
        int currentDigit = 0;
        int currentAlpha = 0;
        boolean isDigit = digitNumber >= alphaNumber;
        int pos = 0;
        while (pos < n) {
            if (isDigit) {
                while (digits[currentDigit] == 0) currentDigit++;
                ans[pos] = (char) ('0' + currentDigit);
                digits[currentDigit]--;
            } else {
                while (alphas[currentAlpha] == 0) currentAlpha++;
                ans[pos] = (char) ('a' + currentAlpha);
                alphas[currentAlpha]--;
            }
            isDigit = !isDigit;
            pos++;
        }
        return new String(ans);
    }
}
