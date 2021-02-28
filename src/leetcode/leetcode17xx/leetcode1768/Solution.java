package leetcode.leetcode17xx.leetcode1768;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        char[] ans = new char[n1 + n2];
        int minN = Math.min(n1, n2);
        int pos = 0;
        for (int i = 0; i < minN; i++) {
            ans[pos++] = word1.charAt(i);
            ans[pos++] = word2.charAt(i);
        }
        for (int i = minN; i < n1; i++) ans[pos++] = word1.charAt(i);
        for (int i = minN; i < n2; i++) ans[pos++] = word2.charAt(i);
        return new String(ans);
    }
}
