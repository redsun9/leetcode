package leetcode.leetcode17xx.leetcode1701;

public class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long ans = 0;
        long time = 0;
        for (int[] customer : customers) {
            time = Math.max(time, customer[0]) + customer[1];
            ans += time - customer[0];
        }
        return (double) ans / n;
    }
}
