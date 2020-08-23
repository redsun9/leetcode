package leetcode.leetcode15xx.leetcode1563;


// bottom-up solution
// o(n^3)
public class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        if (n == 1) return 0;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) presum[i + 1] = presum[i] + stoneValue[i];
        int[][] dp = new int[n][n];
        for (int l = 1; l < n; l++) {
            for (int j = l; j < n; j++) {
                int i = j - l;
                int max = 0;
                for (int k = i + 1; k <= j; k++) {
                    int left = presum[k] - presum[i];
                    int right = presum[j + 1] - presum[k];
                    int leftVal = left + dp[i][k - 1];
                    int rightVal = right + dp[k][j];
                    if (left == right) {
                        max = Math.max(max, Math.max(leftVal, rightVal));
                    } else if (left < right) {
                        max = Math.max(max, leftVal);
                    } else {
                        max = Math.max(max, rightVal);
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n - 1];
    }
}
