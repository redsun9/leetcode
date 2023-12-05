package leetcode.leetcode25xx.leetcode2566;

public class Solution {
    public int minMaxDifference(int num) {
        if (num < 10) return 9;
        return diffForMinimum(num) + diffForMaximum(num);
    }

    private static int diffForMinimum(int num) {
        int firstDigit = num;
        while (firstDigit >= 10) firstDigit /= 10;
        return firstDigit * calculateMask(num, firstDigit);
    }

    private static int diffForMaximum(int num) {
        int highestNonNineDigit = 9;
        int tmp = num;
        while (tmp != 0) {
            int digit = tmp % 10;
            if (digit != 9) highestNonNineDigit = digit;
            tmp /= 10;
        }
        return (9 - highestNonNineDigit) * calculateMask(num, highestNonNineDigit);
    }

    private static int calculateMask(int num, int digit) {
        int power = 1;
        int ans = 0;
        int tmp = num;
        while (tmp != 0) {
            if (tmp % 10 == digit) ans += power;
            tmp /= 10;
            power *= 10;
        }
        return ans;
    }

}
