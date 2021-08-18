package leetcode.leetcode7xx.leetcode714;

public class Solution2 {
    public int maxProfit(int[] prices, int fee) {
        long maxSold = 0, maxBuy = Integer.MIN_VALUE, previousMaxSold;
        for (int price : prices) {
            previousMaxSold = maxSold;
            maxSold = Math.max(maxSold, maxBuy + price - fee);
            maxBuy = Math.max(maxBuy, previousMaxSold - price);
        }
        return (int) maxSold;
    }
}
