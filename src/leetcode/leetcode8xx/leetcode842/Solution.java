package leetcode.leetcode8xx.leetcode842;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        int n = num.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = num.charAt(i) - '0';
        }
        if (n < 3) return Collections.emptyList();
        for (int i = 1; i <= Math.min((n - 1) / 2, 10); i++) {
            for (int j = 1; Math.max(i, j) <= Math.min(n - i - j, 10); j++) {
                if (check(i, j, digits)) return createAnswer(digits, i, j);
            }
        }
        return Collections.emptyList();
    }

    private static List<Integer> createAnswer(int[] digits, int i, int j) {
        int a = 0;
        for (int t = 0; t < i; t++) {
            a = a * 10 + digits[t];
        }
        int b = 0;
        for (int t = i; t < i + j; t++) {
            b = b * 10 + digits[t];
        }
        List<Integer> ans = new LinkedList<>();
        ans.add(a);
        ans.add(b);
        int pos = i + j;
        while (pos < digits.length) {
            int c = a + b;
            int d = digitNumber(c);
            ans.add(c);
            pos += d;
            a = b;
            b = c;
        }
        return ans;
    }

    private static boolean check(int i, int j, int[] digits) {
        int n = digits.length;
        if (digits[0] == 0 && i > 1 || digits[i] == 0 && j > 1) return false;
        long a = 0;
        for (int t = 0; t < i; t++) {
            a = a * 10 + digits[t];
        }
        long b = 0;
        for (int t = i; t < i + j; t++) {
            b = b * 10 + digits[t];
        }
        long c = a + b;
        int pos = i + j;
        int d = digitNumber(c);
        if (failed(digits, c, pos, pos + d)) return false;
        pos += d;
        a = b;
        b = c;
        while (pos < n) {
            c = a + b;
            d = digitNumber(c);
            if (failed(digits, c, pos, pos + d)) return false;
            pos += d;
            a = b;
            b = c;
        }
        return true;
    }

    private static int digitNumber(long a) {
        int ans = 1;
        while (a >= 10) {
            ans++;
            a /= 10;
        }
        return ans;
    }

    private static boolean failed(int[] digits, long a, int from, int to) {
        if (a > Integer.MAX_VALUE || to > digits.length || to - from > 1 && digits[from] == 0) return true;
        while (from != to) {
            if (a % 10 != digits[--to]) return true;
            a /= 10;
        }
        return a != 0;
    }


}
