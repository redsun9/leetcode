package leetcode.leetcode7xx.leetcode753;

import java.util.Arrays;

public class Solution {
    private static int db(int n, int k, int t, int p, char[] a, char[] ans, int ansLength) {
        if (t > n) {
            if (n % p == 0) {
                System.arraycopy(a, 1, ans, ansLength, p);
                ansLength += p;
            }
        } else {
            a[t] = a[t - p];
            ansLength = db(n, k, t + 1, p, a, ans, ansLength);
            for (int j = a[t - p] - '0' + 1; j < k; j++) {
                a[t] = (char) ('0' + j);
                ansLength = db(n, k, t + 1, t, a, ans, ansLength);
            }
        }
        return ansLength;
    }

    //a^n
    private static int binPow(int a, int n) {
        int res = 1;
        int tmp = a;
        while (n != 0) {
            if ((n & 1) != 0)
                res *= tmp;
            tmp *= tmp;
            n >>= 1;
        }
        return res;
    }

    public String crackSafe(int n, int k) {
        char[] ans = new char[binPow(k, n) + n - 1];
        Arrays.fill(ans, '0');
        if (k != 1) {
            char[] a = new char[k * n];
            Arrays.fill(a, '0');
            db(n, k, 1, 1, a, ans, 0);
            System.arraycopy(ans, 0, ans, ans.length - n + 1, n - 1);
        }
        return new String(ans);
    }
}
