package leetcode.leetcode16xx.leetcode1687;

import java.util.Arrays;

public class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n * 2);
        dp[0] = 0;
        int additionalTrips = 0;
        int curWeight = 0, curBoxes = 0;
        for (int i = 0, j = 0, lastSame = 0; i < n; i++) {
            while (j < n && curBoxes < maxBoxes && curWeight + boxes[j][1] <= maxWeight) {
                curBoxes++;
                curWeight += boxes[j][1];
                if (j == 0 || boxes[j][0] != boxes[j - 1][0]) {
                    lastSame = j;
                    additionalTrips++;
                }
                j++;
            }
            dp[j] = Math.min(dp[j], dp[i] + additionalTrips + 1);
            dp[lastSame] = Math.min(dp[lastSame], dp[i] + additionalTrips);
            curBoxes--;
            curWeight -= boxes[i][1];
            if (i == n - 1 || boxes[i][0] != boxes[i + 1][0]) additionalTrips--;
        }
        return dp[n];
    }
}
