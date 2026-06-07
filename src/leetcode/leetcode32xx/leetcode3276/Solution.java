package leetcode.leetcode32xx.leetcode3276;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static final int MAX_VAL = 100;

    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        int[] masks = new int[MAX_VAL + 1];
        for (int i = 0; i < m; i++) for (Integer value : grid.get(i)) masks[value] |= 1 << i;
        return dfs(MAX_VAL, (1 << m) - 1, masks, new HashMap<>());
    }

    private int dfs(int curValue, int leftRows, int[] masks, Map<Key, Integer> cache) {
        if (leftRows == 0) return 0;
        while (curValue > 0 && (masks[curValue] & leftRows) == 0) curValue--;
        if (curValue == 0) return 0;
        Key key = new Key(curValue, leftRows);
        int ans = cache.getOrDefault(key, -1);
        if (ans == -1) {
            ans = 0;
            for (int tmp = masks[curValue] & leftRows; tmp != 0; tmp &= (tmp - 1)) {
                int bit = tmp ^ (tmp & (tmp - 1));
                ans = Math.max(ans, dfs(curValue - 1, leftRows ^ bit, masks, cache));
            }
            ans += curValue;
            cache.put(key, ans);
        }
        return ans;
    }

    private record Key(int curValue, int leftRows) {
    }
}
