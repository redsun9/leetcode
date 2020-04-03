package leetcode.leetcode13xx.leetcode1317;

public class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = 0, b = 0;
        int ten = 1;
        while (n > 10) {
            int m = n % 10;
            if (m >= 2) {
                a += ten;
                b += (m - 1) * ten;
                n /= 10;
            } else {
                a += 5 * ten;
                b += (5 + m) * ten;
                n /= 10;
                n--;
            }
            ten *= 10;
        }
        if (n == 10) {
            a += 5 * ten;
            b += 5 * ten;
        } else if (n != 0) {
            a += ten;
            b += (n - 1) * ten;
        }
        return new int[]{a, b};
    }
}
