package leetcode.leetcode5xx.leetcode546;

//bottom-up
public class Solution2 {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        if (n == 0) return 0;
        int[][][] dp = new int[n][n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= i; k++) {
                dp[i][i][k] = (k + 1) * (k + 1);
            }
        }
        // i - start, j - end (inclusive),
        // k - number of preceding balls of the same colour as boxes[i], l = j-i
        for (int l = 1; l < n; l++) {
            for (int j = l; j < n; j++) {
                int i = j - l;

                for (int k = 0; k <= i; k++) {
                    int max = (k + 1) * (k + 1) + dp[i + 1][j][0];

                    for (int m = i + 1; m <= j; m++) {
                        if (boxes[m] == boxes[i]) {
                            max = Math.max(max, dp[i + 1][m - 1][0] + dp[m][j][k + 1]);
                        }
                    }

                    dp[i][j][k] = max;
                }
            }
        }
        return dp[0][n - 1][0];
    }
}
