package leetcode.leetcode2xx.leetcode279;

public class Solution {
    public int numSquares(int n) {
        if (isSquare(n)) return 1;
        if (isOnlyWithFour(n)) return 4;
        if (isSumOfTwoSquares(n)) return 2;
        return 3;
    }

    private static boolean isSquare(long n) {
        long a = (long) Math.floor(Math.sqrt(n));
        return a * a == n;
    }

    private static boolean isSumOfTwoSquares(long n) {
        if (n % 4 == 3) return false;
        while (n % 2 == 0) n /= 2;
        int p = 3;
        while (p * p <= n) {
            int c = 0;
            while (n % p == 0) {
                c++;
                n /= p;
            }
            if (p % 4 == 3 && c % 2 != 0) return false;
            p += 2;
        }
        return n % 4 != 3;
    }

    private static boolean isOnlyWithFour(long n) {
        while (n % 4 == 0) n /= 4;
        return n % 8 == 7;
    }
}
