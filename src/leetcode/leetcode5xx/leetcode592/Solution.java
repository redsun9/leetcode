package leetcode.leetcode5xx.leetcode592;

public class Solution {
    //greatest common divisor
    public static long gcd(long a, long b) {
        long c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }

    public String fractionAddition(String s) {
        int n = s.length();
        long ans1 = 0, ans2 = 1;
        int i = 0;
        while (i < n) {
            boolean positive = s.charAt(i) != '-';
            if (s.charAt(i) == '-' || s.charAt(i) == '+') i++;
            long numerator = 0;
            while (s.charAt(i) != '/') {
                numerator = numerator * 10 + s.charAt(i) - '0';
                i++;
            }
            i++;
            long denominator = 0;
            while (i < n && Character.isDigit(s.charAt(i))) {
                denominator = denominator * 10 + s.charAt(i) - '0';
                i++;
            }
            if (!positive) numerator = -numerator;
            ans1 = ans1 * denominator + ans2 * numerator;
            ans2 *= denominator;
            long gcd = gcd(ans1, ans2);
            ans1 /= gcd;
            ans2 /= gcd;
        }
        if (ans2 < 0) {
            ans1 = -ans1;
            ans2 = -ans2;
        }
        return ans1 + "/" + ans2;
    }
}
