package leetcode.leetcode11xx.leetcode1143;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) return 0;
        if (n > m) {
            int t = m;
            m = n;
            n = t;
            String tmp = text1;
            text1 = text2;
            text2 = tmp;
        }
        int[] previous = new int[n + 1];
        int[] current = new int[n + 1];
        for (int i = 0; i < m; i++) {
            char a = text1.charAt(i);
            int[] t = current;
            current = previous;
            previous = t;
            current[0] = 0;
            for (int j = 0; j < n; j++) {
                char b = text2.charAt(j);
                if (a == b) current[j + 1] = previous[j] + 1;
                else current[j + 1] = Math.max(previous[j + 1], current[j]);
            }
        }
        return current[n];

    }
}
