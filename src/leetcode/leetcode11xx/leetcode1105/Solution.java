package leetcode.leetcode11xx.leetcode1105;

public class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i, w = 0, h = 0; j >= 0; j--) {
                w += books[j][0];
                if (w > shelfWidth) break;
                h = Math.max(h, books[j][1]);
                min = Math.min(min, dp[j] + h);
            }
            dp[i + 1] = min;
        }
        return dp[n];
    }
}
