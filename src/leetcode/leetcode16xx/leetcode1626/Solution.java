package leetcode.leetcode16xx.leetcode1626;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] players = new int[n][];
        for (int i = 0; i < n; i++) players[i] = new int[]{ages[i], scores[i]};
        Arrays.sort(players, Comparator.comparingInt((int[] x) -> -x[0]).thenComparingInt(x -> -x[1]));
        int ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int score = players[i][1];
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (players[j][1] >= score) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + score;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
