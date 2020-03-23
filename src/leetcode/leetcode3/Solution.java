package leetcode.leetcode3;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        HashMap<Character, Integer> lastPosition = new HashMap<>();
        int maxLength = 0;
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            Integer previous = lastPosition.put(chars[i], i);
            if (previous != null) {
                start = Math.max(start, previous + 1);
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
