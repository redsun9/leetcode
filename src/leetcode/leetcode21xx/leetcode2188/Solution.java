package leetcode.leetcode21xx.leetcode2188;

import java.util.Arrays;

public class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int[] minForNumberOfLaps = new int[20];
        int maxLapsOnTheSameTire = 1;
        Arrays.fill(minForNumberOfLaps, Integer.MAX_VALUE);
        for (int[] tire : tires) {
            int f = tire[0], r = tire[1], c = 1, s = f;
            while (10 * changeTime >= s) {
                maxLapsOnTheSameTire = Math.max(maxLapsOnTheSameTire, c);
                minForNumberOfLaps[c] = Math.min(minForNumberOfLaps[c], s);
                f *= r;
                c++;
                s += f;
            }
        }
        int[] dp = new int[numLaps + 1];
        dp[0] = -changeTime;
        for (int i = 1; i <= numLaps; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = Math.max(0, i - maxLapsOnTheSameTire), d = i - j; j < i; j++, d--) {
                tmp = Math.min(tmp, dp[j] + minForNumberOfLaps[d]);
            }
            dp[i] = tmp + changeTime;
        }
        return dp[numLaps];
    }
}
