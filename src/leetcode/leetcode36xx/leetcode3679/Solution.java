package leetcode.leetcode36xx.leetcode3679;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arrivals.length;
        boolean[] discarded = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (i >= w && !discarded[i - w]) map.compute(arrivals[i - w], (k, v) -> v - 1);

            int prev = map.getOrDefault(arrivals[i], 0);
            if (prev == m) discarded[i] = true;
            else map.put(arrivals[i], prev + 1);
        }

        int ans = 0;
        for (boolean b : discarded) if (b) ans++;
        return ans;
    }
}
