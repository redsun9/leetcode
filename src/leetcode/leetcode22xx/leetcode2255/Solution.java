package leetcode.leetcode22xx.leetcode2255;

public class Solution {
    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for (String word : words) if (s.startsWith(word)) ans++;
        return ans;
    }
}
