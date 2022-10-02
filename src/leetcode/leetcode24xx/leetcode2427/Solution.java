package leetcode.leetcode24xx.leetcode2427;

public class Solution {
    private static final int[] firstPrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

    public int commonFactors(int a, int b) {
        return numberOfDivisors(gcd(a, b));
    }


    private static int numberOfDivisors(int n) {
        int ans = 1;
        for (int prime : firstPrimes) {
            int cnt = 0;
            while (n % prime == 0) {
                cnt++;
                n /= prime;
            }
            ans *= 1 + cnt;
        }
        if (n != 1) ans *= 2;
        return ans;
    }


    public static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
