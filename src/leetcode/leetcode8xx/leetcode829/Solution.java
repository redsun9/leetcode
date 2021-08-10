package leetcode.leetcode8xx.leetcode829;

// sum_{i=0}^{n-1} (a+i) = n(2q+n-1)/2
// 2S = n*(2A+n-1) = x*y
// if x is even then y - should be odd and vice versa
// also y>x, as A should be positive integer

// so we present s as m*2^k, there m - is odd, and find number of divisors m

public class Solution {
    public int consecutiveNumbersSum(int s) {
        s /= s ^ (s & (s - 1)); // divide by 2 until odd
        int ans = 1;
        for (int i = 3; i * i <= s; i += 2) {
            if (s % i == 0) {
                int c = 0;
                while (s % i == 0) {
                    c++;
                    s /= i;
                }
                ans *= (c + 1);
            }
        }
        if (s != 1) ans *= 2;
        return ans;
    }
}
