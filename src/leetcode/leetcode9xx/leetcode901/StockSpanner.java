package leetcode.leetcode9xx.leetcode901;

import java.util.Stack;

public class StockSpanner {
    private int counter;
    private final Stack<Integer> priceStack = new Stack<>();
    private final Stack<Integer> dayStack = new Stack<>();

    public StockSpanner() {
        priceStack.push(Integer.MAX_VALUE);
        dayStack.push(0);
    }

    public int next(int price) {
        counter++;
        while (!priceStack.isEmpty() && priceStack.peek() <= price) {
            priceStack.pop();
            dayStack.pop();
        }
        int ans = counter - dayStack.peek();
        priceStack.push(price);
        dayStack.push(counter);
        return ans;
    }
}
