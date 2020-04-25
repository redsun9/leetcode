package leetcode.leetcode0xx.leetcode91;

public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int prepreviousValue = 0;
        int previousValue = 1;
        int previousDigit = 0;
        int currentSymbol, currentValue, dd;
        for (int i = 0; i < n; i++) {
            currentSymbol = s.charAt(i) - '0';
            currentValue = 0;
            if (currentSymbol != 0) currentValue += previousValue;
            dd = previousDigit * 10 + currentSymbol;
            if (dd >= 10 && dd <= 26) currentValue += prepreviousValue;
            if (currentValue == 0) return 0;
            previousDigit = currentSymbol;
            prepreviousValue = previousValue;
            previousValue = currentValue;
        }
        return previousValue;
    }
}