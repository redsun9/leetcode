package leetcode.leetcode13xx.leetcode1323;

public class Solution {
    public int maximum69Number(int num) {
        int tmp = num;
        int maxDigit = 0;
        int i = 3;
        while (tmp != 0) {
            if (tmp % 10 == 6) maxDigit = i;
            tmp /= 10;
            i *= 10;
        }
        return num + maxDigit;

    }
}
