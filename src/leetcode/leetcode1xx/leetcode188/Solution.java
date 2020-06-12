package leetcode.leetcode1xx.leetcode188;

import java.util.Arrays;

public class Solution {
    //max buy and sell with at most k transactions
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (prices.length <= 1 || k == 0) return 0;
        k = Math.min(k, n / 2);
        int[] sell = new int[k + 1];
        int[] buy = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);
        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                buy[i] = Math.min(buy[i], price - sell[i]);
                sell[i + 1] = Math.max(sell[i + 1], price - buy[i]);
            }
        }
        return sell[k];
    }
}
