package leetcode.leetcode5xx.leetcode524;

import java.util.List;

public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        int m = s.length();
        String ans = "";
        for (String word : dictionary) {
            int n = word.length();
            if (n > m || n < ans.length() || n == ans.length() && ans.compareTo(word) < 0) continue;
            int i = 0, j = 0;
            while (i < m && j < n) if (s.charAt(i++) == word.charAt(j)) j++;
            if (j == n) ans = word;
        }
        return ans;
    }
}
