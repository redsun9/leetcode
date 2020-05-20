package leetcode.leetcode4xx.leetcode424;

public class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        int ans = 0, start = 0, end = 0, maxCount = 0;
        while (end < n) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) count[s.charAt(start++) - 'A']--;
            ans = Math.max(ans, end++ - start + 1);
        }
        return ans;
    }
}
