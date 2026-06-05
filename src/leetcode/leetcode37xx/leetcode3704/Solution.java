package leetcode.leetcode37xx.leetcode3704;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long countNoZeroPairs(long n) {
        if (n <= 1) return 0;
        return dfs(n, 1, false, false, false, true, new HashMap<>());
    }

    private long dfs(long n, long curBase, boolean minusOne, boolean hasZero1, boolean hasZero2, boolean same, Map<Key, Long> cache) {
        if (curBase > n) return minusOne ? 0 : 1;

        int curDigit = (int) (n / curBase % 10) + (minusOne ? -1 : 0);
        Key key = new Key(n, curBase, minusOne, hasZero1, hasZero2, same);
        long ans = cache.getOrDefault(key, -1L);
        if (ans == -1) {
            ans = 0;
            for (int d1 = 0, d2 = curDigit; d1 <= 9; d1++, d2--) {
                int actualD2 = (d2 + 10) % 10;
                if (curBase == 1 && (d1 == 0 || actualD2 == 0)) continue;
                if (hasZero1 && d1 != 0 || hasZero2 && actualD2 != 0) continue;
                ans += dfs(n, curBase * 10, d2 < 0, hasZero1 || (d1 == 0), hasZero2 || (actualD2 == 0), same && (d1 == actualD2), cache);
            }
            cache.put(key, ans);
        }
        return ans;
    }

    private record Key(long n, long curDigit, boolean minusOne, boolean hasZero1, boolean hasZero2, boolean same) {
    }
}
