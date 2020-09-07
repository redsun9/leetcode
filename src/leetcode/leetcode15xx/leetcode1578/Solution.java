package leetcode.leetcode15xx.leetcode1578;

public class Solution {
    public int minCost(String s, int[] cost) {
        int n = cost.length;
        int ans = 0;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += cost[i];
            max = Math.max(max, cost[i]);
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                ans += sum - max;
                sum = 0;
                max = 0;
            }
        }
        return ans;
    }
}
