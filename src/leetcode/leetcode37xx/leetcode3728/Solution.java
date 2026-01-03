package leetcode.leetcode37xx.leetcode3728;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long countStableSubarrays(int[] capacity) {
        Map<Key, Integer> map = new HashMap<>();
        long pref = 0, ans = 0;
        Key key = null;
        for (int num : capacity) {
            ans += map.getOrDefault(new Key(num, pref - num), 0);
            pref += num;
            if (key != null) map.put(key, map.getOrDefault(key, 0) + 1);
            key = new Key(num, pref);
        }
        return ans;
    }

    private record Key(int num, long prefSum) {
    }
}
