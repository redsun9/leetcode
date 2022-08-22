package leetcode.leetcode23xx.leetcode2384;

public class Solution {
    public String largestPalindromic(String num) {
        int n = num.length();
        if (n == 1) return num;
        int[] cnt = new int[10];
        for (int i = 0; i < n; i++) cnt[num.charAt(i) - '0']++;

        boolean usedDigits = false;
        int largestDigitForCenter = -1, largestDigit = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (cnt[i] == 0) continue;
            if (largestDigit == 0) largestDigit = i;
            if (cnt[i] >= 2) {
                if (i != 0) usedDigits = true;
                sb.append(String.valueOf((char) ('0' + i)).repeat(cnt[i] >> 1));
            }
            if (largestDigitForCenter == -1 && (cnt[i] & 1) == 1) largestDigitForCenter = i;
        }

        if (!usedDigits) return String.valueOf(largestDigit);
        if (largestDigitForCenter != -1) return sb.toString() + largestDigitForCenter + sb.reverse();
        else return sb.toString() + sb.reverse();


    }
}
