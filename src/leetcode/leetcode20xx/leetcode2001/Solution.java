package leetcode.leetcode20xx.leetcode2001;

import java.util.HashMap;
import java.util.Objects;

public class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Fraction, Integer> map = new HashMap<>();
        long ans = 0;
        for (int[] rectangle : rectangles) {
            Fraction pair = new Fraction(rectangle[0], rectangle[1]);
            ans += map.getOrDefault(pair, 0);
            map.compute(pair, (k, v) -> v == null ? 1 : v + 1);
        }
        return ans;

    }

    private static class Fraction {
        final int a, b;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fraction pair = (Fraction) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        public Fraction(int a, int b) {
            int c = gcd(a, b);
            this.a = a / c;
            this.b = b / c;
        }
    }


    //greatest common divisor
    public static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

}
