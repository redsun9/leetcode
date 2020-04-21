package leetcode.leetcode0xx.leetcode63;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        obstacleGrid[0][0] ^= 1;
        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = (1 - obstacleGrid[0][i]) & obstacleGrid[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (1 - obstacleGrid[i][0]) & obstacleGrid[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            int[] arr = obstacleGrid[i];
            int[] prev = obstacleGrid[i - 1];
            for (int j = 1; j < n; j++) {
                arr[j] = (1 - arr[j]) * (arr[j - 1] + prev[j]);
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
