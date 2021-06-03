package leetcode.leetcode17xx.leetcode1742;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    private static final Map<CacheKey, Integer> cache = new HashMap<>();

    private static int f(int limit, int highestDigit, int targetSum) {
        if (targetSum == 0) return 1;
        if (limit == 0 || highestDigit == 0) return 0;
        CacheKey cacheKey = new CacheKey(limit, targetSum);
        if (!cache.containsKey(cacheKey)) {
            int ans = 0;
            while (limit >= highestDigit) {
                ans += f(highestDigit - 1, highestDigit / 10, targetSum);
                limit -= highestDigit;
                targetSum--;
            }
            ans += f(limit, highestDigit / 10, targetSum);
            cache.put(cacheKey, ans);
        }
        return cache.get(cacheKey);
    }

    public int countBalls(int lowLimit, int highLimit) {
        int maxDigitSum = 45;
        int ans = 0;
        for (int i = 0; i <= maxDigitSum; i++) {
            ans = Math.max(ans, f(highLimit, 100_000, i) - f(lowLimit - 1, 100_000, i));
        }
        return ans;
    }

    private static class CacheKey {
        private final int limit, targetSum;

        public CacheKey(int limit, int targetSum) {
            this.limit = limit;
            this.targetSum = targetSum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CacheKey cacheKey = (CacheKey) o;
            return limit == cacheKey.limit && targetSum == cacheKey.targetSum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(limit, targetSum);
        }
    }


}
