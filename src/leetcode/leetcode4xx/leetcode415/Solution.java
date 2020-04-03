package leetcode.leetcode4xx.leetcode415;

import java.util.Arrays;

public class Solution {
    public String addStrings(String num1, String num2) {
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        char[] c = new char[Math.max(a.length, b.length) + 1];

        final char char10 = (char) ('0' - 10);

        int ai = a.length - 1;
        int bi = b.length - 1;
        int ci = c.length - 1;
        int m = 0;
        while (ai >= 0 && bi >= 0) {
            int v = a[ai] + b[bi] + m - 2 * '0';
            if (v > 9) {
                c[ci] = (char) (v + char10);
                m = 1;
            } else {
                c[ci] = (char) (v + '0');
                m = 0;
            }
            ai--;
            bi--;
            ci--;
        }
        if (ai >= 0) {
            while (ai >= 0) {
                char v = (char) (a[ai] + m);
                if (v <= '9') {
                    c[ci] = v;
                    m = 0;
                } else {
                    c[ci] = (char) (v - 10);
                    m = 1;
                }
                ai--;
                ci--;
            }
        } else if (bi >= 0) {
            while (bi >= 0) {
                char v = (char) (b[bi] + m);
                if (v <= '9') {
                    c[ci] = v;
                    m = 0;
                } else {
                    c[ci] = (char) (v - 10);
                    m = 1;
                }
                bi--;
                ci--;
            }
        }
        if (m > 0) {
            c[ci] = (char) ('0' + m);
            ci--;
        }
        return new String(Arrays.copyOfRange(c, ci + 1, c.length));
    }
}
