package leetcode.leetcode22xx.leetcode2260;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        int n = cards.length;
        for (int i = 0; i < n; i++) {
            Integer prevPos = map.get(cards[i]);
            if (prevPos != null) {
                ans = Math.min(ans, i - prevPos);
                if (ans == 1) return 2;
            }
            map.put(cards[i], i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans + 1;
    }
}
