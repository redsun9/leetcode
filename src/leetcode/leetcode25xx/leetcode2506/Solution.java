package leetcode.leetcode25xx.leetcode2506;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0, n = word.length();
            for (int i = 0; i < n; i++) mask |= 1 << (word.charAt(i) - 'a');
            map.compute(mask, (k, v) -> v == null ? 1 : v + 1);
        }
        int ans = 0;
        for (Integer value : map.values()) ans += value * (value - 1);
        return ans / 2;
    }
}
