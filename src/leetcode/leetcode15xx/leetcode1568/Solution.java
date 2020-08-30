package leetcode.leetcode15xx.leetcode1568;

public class Solution {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minDays(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int cnt = countIsland(grid);
        if (cnt == 0 || cnt > 1) return 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    cnt = countIsland(grid);
                    grid[i][j] = 1;
                    if (cnt == 0 || cnt > 1) return 1;
                }
            }
        return 2;
    }

    private int countIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int cnt = 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                    cnt++;
                }
            }
        return cnt;
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c] || grid[r][c] != 1) return;
        visited[r][c] = true;
        for (int[] d : dirs) {
            dfs(grid, r + d[0], c + d[1], visited);
        }
    }
}
