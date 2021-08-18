package leetcode.leetcode7xx.leetcode714;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int maxSold = 0, maxBuy = Integer.MIN_VALUE, previousMaxSold;
        for (int price : prices) {
            previousMaxSold = maxSold;
            maxSold = Math.max(maxSold, maxBuy + price);
            maxBuy = Math.max(maxBuy, previousMaxSold - price - fee);
        }
        return maxSold;
    }
}
