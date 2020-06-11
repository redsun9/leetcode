package leetcode.leetcode0xx.leetcode50;

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        boolean posN = n >= 0;
        double res = 1;
        double tmp = x;
        n = Math.abs(n);
        while (n != 0) {
            if ((n & 1) != 0)
                res *= tmp;
            tmp *= tmp;
            n >>= 1;
        }
        return posN ? res : 1 / res;
    }
}
