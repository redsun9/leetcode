package leetcode.leetcode5xx.leetcode526;

import java.util.*;

public class Solution2 {
    public long countArrangement(int n) {
        Integer[][] factors = new Integer[n][];
        for (int i = 1; i <= n; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) arr.add(j - 1);
            }
            factors[i - 1] = arr.toArray(new Integer[0]);
        }
        Arrays.sort(factors, Comparator.comparingInt(x -> x.length));
        return dfs(n, 0, 0, factors, new HashMap<>());
    }

    private static long dfs(int n, int pos, long key, Integer[][] factors, Map<Long, Long> cache) {
        if (pos == n) return 1L;
        if (cache.containsKey(key)) return cache.get(key);
        long ans = 0;
        for (Integer factor : factors[pos]) {
            if ((key & (1L << factor)) == 0) {
                ans += dfs(n, pos + 1, key | 1L << factor, factors, cache);
            }
        }
        cache.put(key, ans);
        return ans;
    }
}
