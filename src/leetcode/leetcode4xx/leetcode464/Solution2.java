package leetcode.leetcode4xx.leetcode464;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    private static boolean dfs(int val, int key, int max, Map<Integer, Boolean> cache) {
        if (val <= 0) return false;
        if (cache.containsKey(key)) return cache.get(key);
        for (int i = 0; i < max; i++) {
            if ((key & (1 << i)) == 0 && !dfs(val - i - 1, key ^ (1 << i), max, cache)) {
                cache.put(key, true);
                return true;
            }
        }
        cache.put(key, false);
        return false;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        if (maxChoosableInteger >= desiredTotal) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        return dfs(desiredTotal, 0, maxChoosableInteger, new HashMap<>());
    }
}
