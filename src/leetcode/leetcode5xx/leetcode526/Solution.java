package leetcode.leetcode5xx.leetcode526;

import java.util.*;

//for n from 1 to 29
public class Solution {
    public int countArrangement(int n) {
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

    private static int dfs(int n, int pos, int key, Integer[][] factors, Map<Integer, Integer> cache) {
        if (pos == n) return 1;
        if (cache.containsKey(key)) return cache.get(key);
        int ans = 0;
        for (Integer factor : factors[pos]) {
            if ((key & (1 << factor)) == 0) {
                ans += dfs(n, pos + 1, key | 1 << factor, factors, cache);
            }
        }
        cache.put(key, ans);
        return ans;
    }
}
