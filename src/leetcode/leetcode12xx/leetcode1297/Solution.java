package leetcode.leetcode12xx.leetcode1297;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        if (n < minSize || minSize > maxSize || maxLetters <= 0) return 0;

        int[] count = new int[26];
        int letters = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < n; right++) {
            if (count[s.charAt(right) - 'a']++ == 0) letters++;
            if (right - left == minSize) if (--count[s.charAt(left++) - 'a'] == 0) letters--;
            if (right - left + 1 == minSize && letters <= maxLetters) {
                map.compute(s.substring(left, right + 1), (k, v) -> v == null ? 1 : v + 1);
            }
        }

        int ans = 0;
        for (Integer value : map.values()) ans = Math.max(ans, value);
        return ans;
    }
}
