package leetcode.leetcode15xx.leetcode1599;

public class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int ans = -1, maxProfit = -1, waiting = 0;
        int currentProfit = 0;
        int run = 0;
        for (; run < customers.length; run++) {
            waiting += customers[run];
            int boarding = Math.min(4, waiting);
            currentProfit += boarding * boardingCost - runningCost;
            waiting -= boarding;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                ans = run + 1;
            }
        }
        currentProfit += waiting / 4 * (boardingCost * 4 - runningCost);
        run += waiting / 4;
        if (currentProfit > maxProfit) {
            maxProfit = currentProfit;
            ans = run;
        }
        waiting %= 4;
        if (waiting * boardingCost > runningCost) {
            currentProfit += waiting * boardingCost - runningCost;
            run++;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                ans = run;
            }
        }
        return maxProfit > 0 ? ans : -1;
    }
}
