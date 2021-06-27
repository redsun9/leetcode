package leetcode.leetcode19xx.leetcode1915;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long wonderfulSubstrings(String word) {
        int n = word.length();
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int mask = 0;
        for (int i = 0; i < n; i++) {
            mask ^= 1 << (word.charAt(i) - 'a');
            count.compute(mask, (k, v) -> v == null ? 1 : v + 1);
        }
        long ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int key = entry.getKey();
            long value = entry.getValue();
            ans += value * (value - 1L);
            for (int i = 0; i < 10; i++) {
                ans += value * count.getOrDefault(key ^ (1 << i), 0);
            }
        }
        return ans / 2;
    }
}
