package leetcode.leetcode8xx.leetcode853;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        Arrays.sort(indices, Comparator.comparingInt(i -> position[i]));

        int ans = 0;
        Fraction min = new Fraction(0, 1);
        for (int i = n - 1; i >= 0; i--) {
            Fraction tmp = new Fraction(target - position[indices[i]], speed[indices[i]]);
            if (tmp.compareTo(min) > 0) {
                ans++;
                min = tmp;
            }
        }
        return ans;
    }

    //only non negative supported here
    private static class Fraction implements Comparable<Fraction> {
        private final int numerator, denominator;

        private Fraction(int numerator, int denominator) {
            int gcd = gcd(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }

        @Override
        public int compareTo(Fraction o) {
            return Long.signum((long) numerator * o.denominator - (long) o.numerator * denominator);
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
