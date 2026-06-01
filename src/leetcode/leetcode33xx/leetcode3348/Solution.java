package leetcode.leetcode33xx.leetcode3348;

import java.util.Arrays;

public class Solution {
    public String smallestNumber(String num, long t) {
        int n = num.length();
        int minimumDigits = minimumDigits(t);
        if (minimumDigits == -1) return "-1";
        if (n < minimumDigits) return produceString(minimumDigits, t);

        // find first zero or impossibility
        long[] left = new long[n + 1];
        left[0] = t;
        int pos = 0;
        while (pos < n && num.charAt(pos) != '0') {
            left[pos + 1] = left[pos] / gcd(left[pos], num.charAt(pos) - '0');
            if (minimumDigits(left[pos + 1]) >= n - pos) break;
            pos++;
        }
        if (pos == n) return num;

        while (pos >= 0) {
            for (int newDigit = num.charAt(pos) - '0' + 1; newDigit <= 9; newDigit++) {
                left[pos + 1] = left[pos] / gcd(left[pos], newDigit);
                if (minimumDigits(left[pos + 1]) < n - pos) return num.substring(0, pos) + ((char) ('0' + newDigit)) + produceString(n - 1 - pos, left[pos + 1]);
            }
            pos--;
        }
        return produceString(n + 1, t);
    }

    private static String produceString(int length, long t) {
        char[] ans = new char[length];
        Arrays.fill(ans, '1');
        for (int d = 9, j = ans.length; d >= 2; d--) {
            while (t % d == 0) {
                ans[--j] = (char) ('0' + d);
                t /= d;
            }
        }
        return new String(ans);
    }


    private static int minimumDigits(long n) {
        int ans = 0;
        for (int i = 9; i >= 2; i--) {
            while (n % i == 0) {
                ans++;
                n /= i;
            }
        }
        if (n != 1) return -1;
        return ans;
    }

    private static long gcd(long a, long b) {
        long c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}