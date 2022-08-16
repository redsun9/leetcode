package leetcode.leetcode23xx.leetcode2376;

public class Solution {
    private static final int MAX_POSSIBLE_DIGIT_COUNT = 10;
    private static final int[] numbersWithLessDigits;
    private static final int[] factorials;

    static {
        factorials = new int[10];
        factorials[0] = 1;
        for (int i = 1; i < 10; i++) factorials[i] = factorials[i - 1] * i;

        numbersWithLessDigits = new int[10];
        numbersWithLessDigits[1] = 9;
        for (int i = 2, mul = 9, left = 9; i < 10; i++) {
            mul *= left--;
            numbersWithLessDigits[i] = numbersWithLessDigits[i - 1] + mul;
        }
    }

    public int countSpecialNumbers(int n) {
        int[] digits = new int[MAX_POSSIBLE_DIGIT_COUNT];
        int digitCount = 0;
        do {
            digits[digitCount++] = n % 10;
            n /= 10;
        } while (n != 0);
        int ans = numbersWithLessDigits[digitCount - 1];
        int availableDigits = 1023, i = digitCount - 1;
        boolean firstDigit = true, noDuplicate = true;
        while (i >= 0) {
            //count available digits which are less than corresponding digit in n
            if (digits[i] != 0) {
                int digitLess = availableDigits & ((1 << digits[i]) - 1);
                if (firstDigit) digitLess &= ~1;
                ans += Integer.bitCount(digitLess) * factorials[10 - digitCount + i] / factorials[10 - digitCount];
            }
            noDuplicate = (availableDigits & (1 << digits[i])) != 0;
            if (!noDuplicate) break;
            availableDigits ^= 1 << digits[i];
            firstDigit = false;
            i--;
        }
        if (noDuplicate) ans++;
        return ans;
    }
}
