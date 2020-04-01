package leetcode.leetcode8xx.leetcode805;

import java.util.Arrays;

public class Solution {
    public boolean splitArraySameAverage(int[] a) {
        int n = a.length;
        if (n < 2) return false;
        Arrays.sort(a);
        int totalSum = 0;
        for (int i : a) {
            totalSum += i;
        }
        int gcd = gcd(totalSum, n);
        int avgTop = totalSum / gcd;
        int avgBot = n / gcd;

        if (avgBot == n) return false;
        if (avgBot > 1) {
            for (int i = 0; i < n; i++) {
                a[i] = a[i] * avgBot - avgTop;
            }
        } else {
            for (int i = 0; i < n; i++) {
                a[i] = a[i] - avgTop;
            }
        }

        int lo = 0;
        int hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == 0) return true;
            if (a[mid] > 0) hi = mid - 1;
            else lo = mid + 1;
        }
        if (a[lo] > 0) lo--;
        if (a[hi] < 0) hi++;
        int[] b = new int[n];
        b[lo] = a[lo];
        b[hi] = a[hi];
        for (int i = lo - 1; i >= 0; i--) {
            b[i] = a[i] + b[i + 1];
        }
        for (int i = hi + 1; i < n; i++) {
            b[i] = a[i] + b[i - 1];
        }

        for (int i = 0; i <= lo; i++) {
            if (trySum(a, b, a[i], 1, i + 1, n - 1, lo, hi)) return true;
        }
        return false;
    }

    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }

    private static boolean trySum(int[] a, int[] b, int curSum, int curNum, int start, int end, int lo, int hi) {
        if (curSum == 0) return curNum != a.length;
        if (curSum > 0) {
            if (start > lo || curSum + b[start] > 0) return false;
            for (int i = start; i <= lo; i++) {
                if (trySum(a, b, curSum + a[i], curNum + 1, i + 1, end, lo, hi)) return true;
            }
        } else {
            if (end < hi || curSum + b[end] < 0) return false;
            for (int i = end; i >= hi; i--) {
                if (trySum(a, b, curSum + a[i], curNum + 1, start, i - 1, lo, hi)) return true;
            }
        }
        return false;
    }
}
