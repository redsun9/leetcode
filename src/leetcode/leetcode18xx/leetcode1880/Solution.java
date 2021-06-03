package leetcode.leetcode18xx.leetcode1880;

public class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int overflow = 0;
        int a, b, c;
        int i = firstWord.length() - 1, j = secondWord.length() - 1, k = targetWord.length() - 1;
        while (i >= 0 || j >= 0 || k >= 0) {
            a = i >= 0 ? firstWord.charAt(i) - 'a' : 0;
            b = j >= 0 ? secondWord.charAt(j) - 'a' : 0;
            c = k >= 0 ? targetWord.charAt(k) - 'a' : 0;
            overflow += a + b;
            if (c != overflow % 10) return false;
            overflow /= 10;
            i--;
            j--;
            k--;
        }
        return overflow == 0;
    }
}
