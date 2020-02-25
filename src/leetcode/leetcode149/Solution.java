package leetcode.leetcode149;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n < 3) return points.length;
        int maxPoint = 0;
        int tmpMax, overlap;
        Map<Fraction, Integer> slopeMap = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            tmpMax = 0;
            overlap = 0;
            for (int j = i + 1; j < n; j++) {
                if (Arrays.equals(points[i], points[j])) {
                    overlap++;
                } else {
                    Fraction fraction = new Fraction(points[i][0] - points[j][0], points[i][1] - points[j][1]);
                    tmpMax = Math.max(tmpMax, slopeMap.compute(fraction, (key, value) -> {
                        if (value == null) return 1;
                        else return value + 1;
                    }));
                }
            }
            maxPoint = Math.max(maxPoint, tmpMax + overlap + 1);
            slopeMap.clear();
        }
        return maxPoint;
    }


    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static class Fraction {
        final int first;
        final int second;

        public Fraction(int first, int second) {
            int g = gcd(first, second);
            int t1 = first / g;
            int t2 = second / g;
            if (t2 < 0) {
                t1 = -t1;
                t2 = -t2;
            }
            if (t1 == 0) {
                t2 = 1;
            }
            if (t2 == 0) {
                t1 = 1;
            }
            this.first = t1;
            this.second = t2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fraction fraction = (Fraction) o;
            return first == fraction.first &&
                    second == fraction.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
