package leetcode.leetcode0xx.leetcode72;

public class Solution2 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0 || n == 0) return Math.max(m, n);
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        for (int j = 0; j <= n; j++) prev[j] = j;
        for (int i = 0; i < m; i++) {
            curr[0] = i + 1;
            for (int j = 0; j < n; j++) {
                curr[j + 1] = Math.min(
                        Math.min(prev[j + 1], curr[j]) + 1,
                        prev[j] + (word1.charAt(i) == word2.charAt(j) ? 0 : 1)
                );
            }
            int[] tmp = curr;
            curr = prev;
            prev = tmp;
        }
        return prev[n];
    }
}
