package leetcode.leetcode5xx.leetcode564;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public String nearestPalindromic(String s) {
        int n = s.length();
        if (n == 1) {
            if (s.charAt(0) == '0') return "1";
            else return String.valueOf((char) (s.charAt(0) - 1));
        }
        long target = Long.parseLong(s);
        long num = 0;
        for (int i = 0; i < (n + 1) / 2; i++) num = num * 10L + s.charAt(i) - '0';
        for (int i = n / 2 - 1; i >= 0; i--) num = num * 10L + s.charAt(i) - '0';

        long lower = num < target ? num : floor(num, n);
        long upper = num > target ? num : ceiling(num, n);
        if (target - lower <= upper - target) return String.valueOf(lower);
        else return String.valueOf(upper);
    }

    private static long floor(long num, int n) {
        long leftPart = num / binPow(10, n / 2);
        if (leftPart == binPow(10, (n - 1) / 2)) return binPow(10, n - 1) - 1;
        leftPart--;
        long ans = leftPart;
        if ((n & 1) == 1) leftPart /= 10;
        while (leftPart != 0) {
            ans = ans * 10 + leftPart % 10;
            leftPart /= 10;
        }
        return ans;
    }

    private static long ceiling(long num, int n) {
        long leftPart = num / binPow(10, n / 2);
        if (leftPart == binPow(10, (n + 1) / 2) - 1) return binPow(10, n) + 1;
        leftPart++;
        long ans = leftPart;
        if ((n & 1) == 1) leftPart /= 10;
        while (leftPart != 0) {
            ans = ans * 10 + leftPart % 10;
            leftPart /= 10;
        }
        return ans;
    }

    private static long binPow(int a, int n) {
        long res = 1;
        long tmp = a;
        while (n != 0) {
            if ((n & 1) != 0)
                res *= tmp;
            tmp *= tmp;
            n >>= 1;
        }
        return res;
    }
}
