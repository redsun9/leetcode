package leetcode.leetcode3xx.leetcode309;

import static java.lang.Math.max;

public class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0, hold = Integer.MIN_VALUE, rest = 0;
        for (int price : prices) {
            int prvSold = sold;
            sold = hold + price;
            hold = max(hold, rest - price);
            rest = max(rest, prvSold);
        }
        return max(sold, rest);
    }
}
