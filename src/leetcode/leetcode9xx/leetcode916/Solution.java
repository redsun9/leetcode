package leetcode.leetcode9xx.leetcode916;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> wordSubsets(String[] a, String[] b) {
        int[] count = new int[26];
        for (String s : b) {
            int[] tmp = new int[26];
            for (int i = s.length() - 1; i >= 0; i--) tmp[s.charAt(i) - 'a']++;
            for (int i = 0; i < 26; i++) {
                count[i] = Math.max(count[i], tmp[i]);
            }
        }
        int minLength = 0;
        for (int i = 0; i < 26; i++) minLength += count[i];

        List<String> ans = new LinkedList<>();
        for (String s : a) {
            if (s.length() < minLength) continue;
            int[] tmp = new int[26];
            for (int i = s.length() - 1; i >= 0; i--) tmp[s.charAt(i) - 'a']++;
            int j = 25;
            while (j >= 0 && count[j] <= tmp[j]) j--;
            if (j < 0) ans.add(s);
        }
        return ans;
    }
}
