package leetcode.leetcode18xx.leetcode1854;

public class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] c = new int[2051];
        for (int[] log : logs) {
            c[log[0]]++;
            c[log[1]]--;
        }
        int maxValue = 0;
        int ans = 0;
        int s = 0;
        for (int i = 1950; i <= 2050; i++) {
            s += c[i];
            if (s > maxValue) {
                s = maxValue;
                ans = i;
            }
        }
        return ans;
    }
}
