package leetcode.leetcode16xx.leetcode1686;

import java.util.Arrays;

public class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length, diff = 0;
        for (int i = 0; i < n; i++) {
            aliceValues[i] += bobValues[i];
            diff -= bobValues[i];
        }
        Arrays.sort(aliceValues);
        for (int i = n - 1; i >= 0; i -= 2) diff += aliceValues[i];
        return Integer.signum(diff);
    }
}
