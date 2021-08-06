package leetcode.leetcode10xx.leetcode1010;

public class Solution {
    public int numPairsDivisibleBy60(int[] times) {
        int[] count = new int[60];
        for (int time : times) count[time % 60]++;
        int ans = (int) (((count[0] * (count[0] - 1L) + count[30] * (count[30] - 1L)) / 2));
        for (int i = 1, j = 59; i < 30; i++, j--) ans += count[i] * count[j];
        return ans;
    }
}
