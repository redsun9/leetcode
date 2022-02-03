package leetcode.leetcode21xx.leetcode2140;

public class Solution2 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int from = n - 1; from >= 0; from--) {
            int question = questions[from][0];
            int to = Math.min(questions[from][1] + from + 1, n);
            dp[from] = Math.max(question + dp[to], dp[from + 1]);
        }
        return dp[0];
    }
}
