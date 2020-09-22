package leetcode.leetcode8xx.leetcode803;

public class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;
        int c = hits.length;

        //Mark whether there is a brick at the each hit
        for (int[] h : hits) {
            if (grid[h[0]][h[1]] == 1) grid[h[0]][h[1]] = 0;
            else grid[h[0]][h[1]] = -1;
        }

        //Mark all root bricks as value 2 after all hits, no counting
        for (int i = 0; i < n; i++)
            dfs(0, i, grid);

        //Reversely add the block of each hit back and get count of saved bricks
        int[] ret = new int[c];
        for (int i = c - 1; i >= 0; i--) {
            int[] h = hits[i];
            if (grid[h[0]][h[1]] == -1) continue; //This brick is originally empty
            grid[h[0]][h[1]] = 1; //Bring this brick back
            if (!isConnected2Top(h[0], h[1], grid)) continue;
            ret[i] = dfs(h[0], h[1], grid) - 1;
        }

        return ret;

    }

    //Connect unconnected bricks and mark visited bricks as value 2
    //Return how many extra bricks will be saved bacause of adding (i, j) back, including (i, j) itself
    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
            return 0;
        grid[i][j] = 2;
        return 1 + dfs(i - 1, j, grid) + dfs(i + 1, j, grid) + dfs(i, j - 1, grid) + dfs(i, j + 1, grid);
    }

    //Check whether (i, j) is connected to top
    private boolean isConnected2Top(int i, int j, int[][] grid) {
        // Check if adjacent bricks are not falling or (i, j) itself is on the top
        return (i - 1 >= 0 && grid[i - 1][j] == 2)
                || (i + 1 < grid.length && grid[i + 1][j] == 2)
                || (j - 1 >= 0 && grid[i][j - 1] == 2)
                || (j + 1 < grid[0].length && grid[i][j + 1] == 2)
                || (i == 0);
    }
}
