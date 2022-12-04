package help_requests.stock_exchange;

import static java.lang.Long.MAX_VALUE;

// you have M amount of money
// there is array of stock prices for each day
// you can buy any amount of stock and sell any amount of stocks each day
// what is the maximum amount of money you can earn by buying and selling and stocks
public class Solution {
    public static long getMaximumEarn(int[] prices, long amount) {
        long prevMaxMoney = amount, prevMaxStock = 0, prevMaxStockMoney = amount;
        for (int price : prices) {
            if ((MAX_VALUE - prevMaxStockMoney) / price <= prevMaxStock) return MAX_VALUE;
            long nextMaxMoney = Math.max(prevMaxMoney, prevMaxStock * price + prevMaxStockMoney);
            long tmpStock = prevMaxMoney / price, tmpMoney = prevMaxMoney % price;
            if (tmpStock > prevMaxStock || tmpStock == prevMaxStock && tmpMoney > prevMaxStockMoney) {
                prevMaxStock = tmpStock;
                prevMaxStockMoney = tmpMoney;
            }
            prevMaxMoney = nextMaxMoney;
        }
        return prevMaxMoney;
    }

    public static long getMaximumEarn2(int[] prices, long amount) {
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                if ((MAX_VALUE - amount % prices[i - 1]) / prices[i] <= amount / prices[i - 1]) return MAX_VALUE;
                amount = amount % prices[i - 1] + amount / prices[i - 1] * prices[i];
            }
        }
        return amount;
    }

    public static long getMinimumToEarn(int[] prices, long amount) {
        long lo = 1, hi = amount;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (getMaximumEarn(prices, mid) >= amount) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    //Wrong solution, used just to show
    public static long getMinimumToEarn2(int[] prices, long amount) {
        for (int i = prices.length - 1; i > 0; i--) {
            if (prices[i] > prices[i - 1]) {
                amount = amount / prices[i] * prices[i - 1] + Math.min(prices[i - 1], amount % prices[i]);
            }
        }
        return amount;
    }
}
