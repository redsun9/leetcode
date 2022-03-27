package leetcode.leetcode22xx.leetcode2217;

public class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) ans[i] = kthPalindrome(queries[i], intLength);
        return ans;
    }

    static long kthPalindrome(int query, int length) {
        long numberOfPalindromes = 9L * tenPower((length - 1) >> 1);
        if (query > numberOfPalindromes) return -1;
        query--;
        int[] digits = new int[length];
        for (int i = (length - 1) / 2, j = length / 2; i >= 0; i--, j++) {
            digits[i] = digits[j] = query % 10;
            query /= 10;
        }
        digits[0]++;
        if (length != 1) digits[length - 1]++;

        long ans = 0;
        for (int digit : digits) ans = ans * 10L + digit;
        return ans;
    }

    //a^n
    private static long tenPower(int n) {
        long res = 1;
        long tmp = 10;
        while (n != 0) {
            if ((n & 1) != 0)
                res *= tmp;
            tmp *= tmp;
            n >>= 1;
        }
        return res;
    }
}
