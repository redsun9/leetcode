package leetcode.leetcode14xx.leetcode1432;

public class Solution {
    public int maxDiff(int num) {
        int[] digits = new int[10];
        int numberOfDigits = 0;
        while (numberOfDigits == 0 || num != 0) {
            digits[numberOfDigits++] = num % 10;
            num /= 10;
        }

        int digit = -1;
        int num1 = 0;
        for (int i = numberOfDigits - 1; i >= 0; i--) {
            if (digit == -1 && digits[i] != 9) digit = digits[i];
            num1 = num1 * 10 + (digits[i] == digit ? 9 : digits[i]);
        }

        int num2 = 0;
        digit = -1;
        int replace = -1;
        for (int i = numberOfDigits - 1; i >= 0; i--) {
            if (digit == -1 && digits[i] > 1) {
                digit = digits[i];
                replace = (i != numberOfDigits - 1) ? 0 : 1;
            }
            num2 = num2 * 10 + (digits[i] == digit ? replace : digits[i]);
        }
        return num1 - num2;
    }
}
