package leetcode.leetcode10xx.leetcode1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> commonChars(String[] words) {
        int[] counts = new int[26];
        int[] tmp = new int[26];
        Arrays.fill(counts, Integer.MAX_VALUE);
        for (String word : words) {
            Arrays.fill(tmp, 0);
            int n = word.length();
            for (int i = 0; i < n; i++) tmp[word.charAt(i) - 'a']++;
            for (int i = 0; i < 26; i++) {
                counts[i] = Math.min(counts[i], tmp[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int count = counts[i];
            if (count > 0) {
                String s = Character.toString((char) ('a' + i));
                while (count-- > 0) ans.add(s);
            }
        }
        return ans;
    }
}
