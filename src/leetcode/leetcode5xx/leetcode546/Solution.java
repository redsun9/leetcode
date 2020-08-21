package leetcode.leetcode5xx.leetcode546;

//top-down
public class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return dfs(boxes, 0, n - 1, 0, dp);
    }

    // i - start, j - end (inclusive), k - number of preceding balls of the same colour as boxes[i]
    private static int dfs(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];
        while (i < j && boxes[i] == boxes[i + 1]) {
            i++;
            k++;
        }
        int ans = (k + 1) * (k + 1) + dfs(boxes, i + 1, j, 0, dp);
        for (int m = i + 1; m <= j; m++) {
            if (boxes[i] == boxes[m]) {
                ans = Math.max(ans, dfs(boxes, i + 1, m - 1, 0, dp) + dfs(boxes, m, j, k + 1, dp));
            }
        }
        dp[i][j][k] = ans;
        return ans;
    }
}
