package leetcode.leetcode20xx.leetcode2085;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = count(words1);
        Map<String, Integer> map2 = count(words2);
        int ans = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1 && map2.getOrDefault(entry.getKey(), 0) == 1) ans++;
        }
        return ans;
    }

    private static Map<String, Integer> count(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.compute(word, (k, v) -> v == null ? 1 : v + 1);
        return map;
    }
}
