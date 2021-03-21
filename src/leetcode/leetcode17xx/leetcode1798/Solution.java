package leetcode.leetcode17xx.leetcode1798;

import java.util.Arrays;

public class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int ans = 0;
        for (int coin : coins) {
            if (ans + 1 >= coin) ans += coin;
            else return ans + 1;
        }
        return ans + 1;
    }
}
