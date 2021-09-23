package leetcode.leetcode2xx.leetcode245;

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int n = words.length;
        int ans = n;
        if (word1.equals(word2)) {
            int prev = -n;
            for (int i = 0; i < n; i++) {
                if (words[i].equals(word1)) {
                    ans = Math.min(ans, i - prev);
                    if (ans == 1) return 1;
                    prev = i;
                }
            }

        } else {
            int i1 = -n, i2 = -n;
            for (int i = 0; i < n; i++) {
                if (words[i].equals(word1)) {
                    i1 = i;
                    ans = Math.min(ans, i1 - i2);
                    if (ans == 1) return 1;
                } else if (words[i].equals(word2)) {
                    i2 = i;
                    ans = Math.min(ans, i2 - i1);
                    if (ans == 1) return 1;
                }
            }
        }
        return ans;
    }
}
