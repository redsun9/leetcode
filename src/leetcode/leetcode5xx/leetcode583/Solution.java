package leetcode.leetcode5xx.leetcode583;

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (n > m) {
            int t = m;
            m = n;
            n = t;
            String tmpString = word1;
            word1 = word2;
            word2 = tmpString;
        }
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        int[] tmpArray;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) curr[j] = i + j;
                else if (str1[i - 1] == str2[j - 1]) curr[j] = prev[j - 1];
                else curr[j] = 1 + Math.min(prev[j], curr[j - 1]);
            }
            tmpArray = prev;
            prev = curr;
            curr = tmpArray;
        }
        return prev[n];
    }
}
