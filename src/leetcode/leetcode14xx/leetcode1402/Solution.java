package leetcode.leetcode14xx.leetcode1402;

import java.util.Arrays;

public class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = 0;
        int sum = 0;
        int sat = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            sum += satisfaction[i];
            sat += sum;
            max = Math.max(max, sat);
        }
        return max;
    }
}
