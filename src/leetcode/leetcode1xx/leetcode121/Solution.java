package leetcode.leetcode1xx.leetcode121;

public class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int buy = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price > buy) ans = Math.max(ans, price - buy);
            else buy = price;
        }
        return ans;
    }
}
