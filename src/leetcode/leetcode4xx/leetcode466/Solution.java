package leetcode.leetcode4xx.leetcode466;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int l1 = arr1.length;
        int l2 = arr2.length;
        long maxL1 = (long) l1 * n1;
        long i1 = 0, i2 = 0;
        int mod1 = 0, mod2 = 0;

        Map<Pair, long[]> map = new HashMap<>();
        while (i1 < maxL1) {
            if (arr1[mod1] == arr2[mod2]) {
                Pair pair = new Pair(mod1, mod2);
                long[] prevVal = map.get(pair);
                if (prevVal != null) {
                    long c1 = i1 - prevVal[0];
                    long c2 = i2 - prevVal[1];
                    long c = (maxL1 - i1) / c1;
                    i1 += c * c1;
                    i2 += c * c2;
                    if (i1 >= maxL1) break;
                } else {
                    map.put(pair, new long[]{i1, i2});
                }
                i2++;
                if (++mod2 == l2) mod2 = 0;
            }
            i1++;
            if (++mod1 == l1) mod1 = 0;
        }
        return (int) (i2 / l2 / n2);
    }


    private static class Pair {
        final int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
