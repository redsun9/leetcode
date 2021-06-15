package leetcode.leetcode4xx.leetcode473;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Solution {
    // a>=b>=c>=d
    private static boolean dfs(long a, long b, long c, long d, long l, int n, int[] matchsticks, HashSet<CacheKey> cache) {
        if (n == 0) return true;
        CacheKey cacheKey = new CacheKey(a, b, c, d);
        if (cache.contains(cacheKey)) return false;
        int stick = matchsticks[--n];

        long d1 = d + stick;
        if (d1 <= l) {
            if (c < d1) {
                if (b < d1) {
                    if (a < d1) {
                        if (dfs(d1, a, b, c, l, n, matchsticks, cache)) return true;
                    } else if (dfs(a, d1, b, c, l, n, matchsticks, cache)) return true;
                } else if (dfs(a, b, d1, c, l, n, matchsticks, cache)) return true;
            } else if (dfs(a, b, c, d1, l, n, matchsticks, cache)) return true;

            long c1 = c + stick;
            if (c1 <= l) {
                if (b < c1) {
                    if (a < c1) {
                        if (dfs(c1, a, b, d, l, n, matchsticks, cache)) return true;
                    } else if (dfs(a, c1, b, d, l, n, matchsticks, cache)) return true;
                } else if (dfs(a, b, c1, d, l, n, matchsticks, cache)) return true;

                long b1 = b + stick;
                if (b1 <= l) {
                    if (a < b1) {
                        if (dfs(b1, a, c, d, l, n, matchsticks, cache)) return true;
                    } else if (dfs(a, b1, c, d, l, n, matchsticks, cache)) return true;

                    long a1 = a + stick;
                    if (a1 <= l) {
                        if (dfs(a1, b, c, d, l, n, matchsticks, cache)) return true;
                    }
                }
            }
        }
        cache.add(cacheKey);
        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        if (matchsticks.length < 4) return false;
        long s = 0;
        for (int matchstick : matchsticks) s += matchstick;
        if (s % 4 != 0) return false;
        long l = s / 4;
        Arrays.sort(matchsticks);
        return dfs(0, 0, 0, 0, l, n, matchsticks, new HashSet<>());
    }

    private static final class CacheKey {
        long a, b, c, d;

        public CacheKey(long a, long b, long c, long d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CacheKey cacheKey = (CacheKey) o;
            return a == cacheKey.a && b == cacheKey.b && c == cacheKey.c && d == cacheKey.d;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c, d);
        }
    }
}
