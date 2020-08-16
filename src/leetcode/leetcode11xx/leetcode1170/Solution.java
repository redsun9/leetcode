package leetcode.leetcode11xx.leetcode1170;

public class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] counts = new int[11];
        for (String word : words) counts[f(word) - 1]++;
        for (int i = 9; i >= 0; i--) counts[i] += counts[i + 1];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) ans[i] = counts[f(queries[i])];
        return ans;
    }

    private static int f(String s) {
        char min = s.charAt(0);
        int ans = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == min) ans++;
            else if (c < min) {
                min = c;
                ans = 1;
            }
        }
        return ans;
    }
}
