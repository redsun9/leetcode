package leetcode.leetcode6xx.leetcode679;

import java.util.HashSet;
import java.util.Objects;

public class Solution {
    public boolean judgePoint24(int[] nums) {
        HashSet<Fraction>[] cache = new HashSet[1 << 4];
        for (int i = 0; i < cache.length; i++) cache[i] = new HashSet<>();
        for (int i = 0; i < nums.length; i++) cache[1 << i].add(new Fraction(nums[i], 1));
        dfs((1 << nums.length) - 1, cache);
        return cache[cache.length - 1].contains(new Fraction(24, 1));
    }

    private static void dfs(final int mask, HashSet<Fraction>[] cache) {
        if ((mask & (mask - 1)) == 0) return;
        if (!cache[mask].isEmpty()) return;
        for (int leftMask = (mask - 1) & mask; leftMask >= Integer.highestOneBit(mask); leftMask = (leftMask - 1) & mask) {
            dfs(leftMask, cache);
            int rightMask = mask ^ leftMask;
            dfs(rightMask, cache);
            HashSet<Fraction> set = cache[mask];
            for (Fraction left : cache[leftMask]) {
                for (Fraction right : cache[rightMask]) {
                    set.add(plus(left, right));
                    set.add(minus(left, right));
                    set.add(minus(right, left));
                    set.add(mul(left, right));
                    if (right.a != 0) set.add(div(left, right));
                    if (left.a != 0) set.add(div(right, left));
                }
            }
        }
    }
    //greatest common divisor

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

    private static Fraction mul(Fraction f1, Fraction f2) {
        int a = f1.a * f2.a;
        int b = f1.b * f2.b;
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
        if (b < 0) {
            b = -b;
            a = -a;
        }
        return new Fraction(a, b);
    }

    private static Fraction plus(Fraction f1, Fraction f2) {
        int a = f1.a * f2.b + f2.a * f1.b;
        int b = f1.b * f2.b;
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
        if (b < 0) {
            b = -b;
            a = -a;
        }
        return new Fraction(a, b);
    }

    private static Fraction minus(Fraction f1, Fraction f2) {
        int a = f1.a * f2.b - f2.a * f1.b;
        int b = f1.b * f2.b;
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
        if (b < 0) {
            b = -b;
            a = -a;
        }
        return new Fraction(a, b);
    }

    private static Fraction div(Fraction f1, Fraction f2) {
        int a = f1.a * f2.b;
        int b = f1.b * f2.a;
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
        if (b < 0) {
            b = -b;
            a = -a;
        }
        return new Fraction(a, b);
    }

    private static class Fraction {
        int a, b;

        public Fraction(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fraction fraction = (Fraction) o;
            return a == fraction.a &&
                    b == fraction.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
