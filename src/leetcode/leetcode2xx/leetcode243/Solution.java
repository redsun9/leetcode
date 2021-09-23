package leetcode.leetcode2xx.leetcode243;

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int n = words.length;
        int ans = n;

        int i1 = -n, i2 = -n;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
                ans = Math.min(ans, i1 - i2);
            } else if (words[i].equals(word2)) {
                i2 = i;
                ans = Math.min(ans, i2 - i1);
            }
        }
        return ans;
    }
}
