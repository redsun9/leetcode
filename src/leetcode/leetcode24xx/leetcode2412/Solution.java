package leetcode.leetcode24xx.leetcode2412;

public class Solution {
    public long minimumMoney(int[][] transactions) {
        int maxCost = 0;
        long totalSpendForAllMinusTransaction = 0;
        for (int[] transaction : transactions) {
            if (transaction[0] <= transaction[1]) maxCost = Math.max(maxCost, transaction[0]);
            else {
                totalSpendForAllMinusTransaction += transaction[0] - transaction[1];
                maxCost = Math.max(maxCost, transaction[1]);
            }
        }
        return totalSpendForAllMinusTransaction + maxCost;
    }
}
