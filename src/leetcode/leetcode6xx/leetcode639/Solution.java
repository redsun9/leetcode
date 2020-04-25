package leetcode.leetcode6xx.leetcode639;

public class Solution {
    public static final int m = 1_000_000_007;

    public int numDecodings(String s) {
        int n = s.length();
        long prepreviousValue = 0;
        long previousValue = 1;
        int previousDigit = 0;
        boolean previousStar = false;
        int currentSymbol, dd;
        long currentValue;
        char c;
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);
            if (c == '*') {
                if (previousStar) {
                    currentValue = prepreviousValue * 15 + previousValue * 9;
                } else {
                    switch (previousDigit) {
                        case 1:
                            currentValue = prepreviousValue * 9 + previousValue * 9;
                            break;
                        case 2:
                            currentValue = prepreviousValue * 6 + previousValue * 9;
                            break;
                        default:
                            currentValue = previousValue * 9;
                            break;
                    }
                }
                previousStar = true;
            } else {
                currentSymbol = c - '0';
                if (previousStar) {
                    if (currentSymbol == 0) {
                        currentValue = prepreviousValue * 2;
                    } else if (currentSymbol <= 6) {
                        currentValue = prepreviousValue * 2 + previousValue;
                    } else {
                        currentValue = prepreviousValue + previousValue;
                    }
                } else {
                    currentValue = 0;
                    if (currentSymbol != 0) currentValue += previousValue;
                    dd = previousDigit * 10 + currentSymbol;
                    if (dd >= 10 && dd <= 26) currentValue += prepreviousValue;
                }
                previousStar = false;
                previousDigit = currentSymbol;
            }
            prepreviousValue = previousValue;
            previousValue = (int) (currentValue % m);
        }
        return (int) previousValue;
    }
}
