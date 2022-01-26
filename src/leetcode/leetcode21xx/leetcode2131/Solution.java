package leetcode.leetcode21xx.leetcode2131;

public class Solution {
    public int longestPalindrome(String[] words) {
        int[][] count = new int[26][26];
        for (String word : words) count[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;

        boolean hasOddDouble = false;
        int ans = 0;
        for (int i = 1; i < 26; i++) for (int j = 0; j < i; j++) ans += Math.min(count[i][j], count[j][i]);
        for (int i = 0; i < 26; i++) {
            hasOddDouble |= ((count[i][i] & 1) == 1);
            ans += count[i][i] >> 1;
        }

        return ans * 4 + (hasOddDouble ? 2 : 0);
    }
}
