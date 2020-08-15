package leetcode.leetcode8xx.leetcode819;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public static final int diff = 'a' - 'A';

    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> counts = new HashMap<>();
        char[] chars = paragraph.toCharArray();
        int n = paragraph.length();
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (!Character.isLetter(chars[i])) {
                if (i != start) {
                    String s = new String(chars, start, i - start);
                    counts.put(s, counts.getOrDefault(s, 0) + 1);
                }
                start = i + 1;
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') chars[i] += diff;
        }
        if (start != n) {
            String s = new String(chars, start, n - start);
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }
        int max = -1;
        String ans = null;
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (!bannedSet.contains(entry.getKey()) && entry.getValue() > max) {
                ans = entry.getKey();
                max = entry.getValue();
            }
        }
        return ans;
    }
}
