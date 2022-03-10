package leetcode.leetcode21xx.leetcode2180;

public class Solution {
    public int countEven(int num) {
        if (num < 10) return num / 2;

        int ans = num / 10 * 5 - 1;
        int lastDigit = num % 10;
        num /= 10;
        int sumWithoutLast = 0;
        while (num != 0) {
            sumWithoutLast += num % 10;
            num /= 10;
        }
        sumWithoutLast &= 1;
        if (sumWithoutLast == 0) return ans + lastDigit / 2 + 1;
        else return ans + (lastDigit + 1) / 2;
    }
}
