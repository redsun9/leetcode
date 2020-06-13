package leetcode.leetcode14xx.leetcode1475;

import java.util.Stack;

public class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = prices.length - 1; i >= 0; i--) {
            while (prices[i] < stack.peek()) stack.pop();
            int discount = prices[i] - stack.peek();
            if (prices[i] != stack.peek()) stack.push(prices[i]);
            prices[i] = discount;
        }
        return prices;
    }
}
