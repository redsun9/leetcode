package leetcode.leetcode3xx.leetcode357;

public class Solution {
    private static final long fact[];

    static {
        fact = new long[11];
        fact[0] = 1;
        fact[1] = 10;
        long tmp = 9;
        for (int i = 2; i <= 10; i++) {
            tmp = tmp * (11 - i);
            fact[i] = fact[i - 1] + tmp;
        }

    }

    public int countNumbersWithUniqueDigits(int n) {
        return (int) fact[n];
    }
}
