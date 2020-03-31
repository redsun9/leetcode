package leetcode.leetcode0xx.leetcode9;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int[] digits = new int[10];
        int dNumber = 0;
        while (x != 0) {
            digits[dNumber] = x % 10;
            x /= 10;
            dNumber++;
        }
        dNumber--;
        for (int i = 0; i < dNumber; i++, dNumber--) {
            if (digits[i] != digits[dNumber]) return false;
        }
        return true;
    }
}
