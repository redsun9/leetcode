package leetcode.leetcode1xx.leetcode120;

import java.util.List;

// Space complexity - O(n)
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int h = n - 1; h >= 0; h--) {
            List<Integer> list = triangle.get(h);
            for (int i = 0; i <= h; i++) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + list.get(i);
            }
        }
        return dp[0];
    }
}
