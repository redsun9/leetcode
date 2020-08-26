package leetcode.leetcode9xx.leetcode983;

import static java.lang.Math.min;

public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int a = costs[0];
        int b = costs[1];
        int c = costs[2];
        int ans = 0;
        int[] dp = new int[n + 1];
        int startOfWeek = 0, startOfMonth = 0, currentDay = 0;
        for (; currentDay < n; currentDay++) {
            int day = days[currentDay];
            while (day - 7 >= days[startOfWeek]) startOfWeek++;
            while (day - 30 >= days[startOfMonth]) startOfMonth++;
            dp[currentDay + 1] = min(dp[currentDay] + a, min(dp[startOfWeek] + b, dp[startOfMonth] + c));
        }
        return dp[n];
    }
}
