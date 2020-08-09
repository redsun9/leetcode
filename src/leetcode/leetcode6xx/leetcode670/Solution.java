package leetcode.leetcode6xx.leetcode670;

public class Solution {
    public int maximumSwap(int num) {
        if (num < 10) return num;
        int[] digits = new int[10];
        int numberOfDigits = 0;
        int tmp = num;
        do {
            digits[numberOfDigits++] = tmp % 10;
            tmp /= 10;
        } while (tmp != 0);

        // find left-most digit which is smaller than next digit
        int leftMostDigit = numberOfDigits - 1;
        while (leftMostDigit > 0 && digits[leftMostDigit] >= digits[leftMostDigit - 1]) leftMostDigit--;
        if (leftMostDigit == 0) return num; //all digits in best positions

        //find rightmost highest digit
        int rightMostDigit = leftMostDigit - 1;
        for (int i = rightMostDigit - 1; i >= 0; i--) {
            if (digits[i] >= digits[rightMostDigit]) rightMostDigit = i;
        }

        //find leftmost digit which is smaller than rightmost
        while (leftMostDigit + 1 < numberOfDigits && digits[leftMostDigit + 1] < digits[rightMostDigit]) leftMostDigit++;

        //swap leftmost ans rightmost
        int t = digits[leftMostDigit];
        digits[leftMostDigit] = digits[rightMostDigit];
        digits[rightMostDigit] = t;

        //get number
        int ans = 0;
        for (int i = numberOfDigits - 1; i >= 0; i--) {
            ans = ans * 10 + digits[i];
        }
        return ans;
    }
}
