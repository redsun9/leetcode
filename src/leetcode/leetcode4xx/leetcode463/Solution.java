package leetcode.leetcode4xx.leetcode463;

public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        if (
                                i + moves[k] < 0 || i + moves[k] >= m ||
                                        j + moves[k + 1] < 0 || j + moves[k + 1] >= n ||
                                        grid[i + moves[k]][j + moves[k + 1]] == 0
                        ) ans++;
                    }
                }
            }
        }
        return ans;
    }
}
