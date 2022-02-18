package leetcode.leetcode21xx.leetcode2165;

import java.util.Arrays;

public class Solution {
    public long smallestNumber(long num) {
        boolean signPositive = num > 0;
        long tmp = Math.abs(num);

        int[] digits = new int[16];
        int numberOfDigits = 0;

        do {
            digits[numberOfDigits++] = (int) (tmp % 10);
            tmp /= 10;
        } while (tmp != 0);

        if (numberOfDigits == 1) return num;
        Arrays.sort(digits, 0, numberOfDigits);

        if (signPositive) {
            int i = 0;
            long multiplier = 1;
            while (digits[i] == 0) {
                i++;
                multiplier *= 10;
            }
            long ans = digits[i++] * multiplier;
            while (i < numberOfDigits) ans = ans * 10 + digits[i++];
            return ans;
        } else {
            long ans = 0;
            while (numberOfDigits != 0) ans = ans * 10 + digits[--numberOfDigits];
            return -ans;
        }
    }

}
