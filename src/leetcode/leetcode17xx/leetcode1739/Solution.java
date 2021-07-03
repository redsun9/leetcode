package leetcode.leetcode17xx.leetcode1739;

import static java.lang.Math.*;

public class Solution {
    public int minimumBoxes(int n) {
        //solve cubic equation 1/6 * x(x+1)(x+2) <= n
        double d = cbrt(3) * cbrt(sqrt(3) * sqrt(243.0 * n * n - 1) + 27.0 * n);
        long k1 = round(d / 3 + 1 / d - 1);
        if (k1 * (k1 + 1) * (k1 + 2) / 6 > n) k1--;
        n = (int) (n - k1 * (k1 + 1) * (k1 + 2) / 6);
        //solve quadratic equation x*(x+1)/2>=n
        long k2 = round((sqrt(8.0 * n + 1) - 1) / 2);
        if (k2 * (k2 + 1) / 2 < n) k2++;
        return (int) (k1 * (k1 + 1) / 2 + k2);
    }
}
