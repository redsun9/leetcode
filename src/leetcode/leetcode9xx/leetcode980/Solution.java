package leetcode.leetcode9xx.leetcode980;

import java.util.Stack;

public class Solution {
    public int uniquePathsIII(int[][] grid) {
        int startI = -1, startJ = -1, endI = -1, endJ = -1;
        int colorDiff = 0;
        int m = grid.length;
        int n = grid[0].length;
        int length = m * n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                switch (grid[i][j]) {
                    case 0:
                        colorDiff += (((i ^ j) << 1) & 2) - 1;
                        break;
                    case 1:
                        startI = i;
                        startJ = j;
                        grid[i][j] = 0;
                        break;
                    case 2:
                        endI = i;
                        endJ = j;
                        grid[i][j] = 0;
                        break;
                    case -1:
                        length--;
                        break;
                }
            }
        }
        if (
                !checkPossibility(
                        ((startI ^ startJ) & 1) == 0,
                        ((endI ^ endJ) & 1) == 0,
                        colorDiff
                ) || !checkConnectivity(grid, startI, startJ, length)
        ) return 0;
        return dfs(grid, startI, startJ, endI, endJ, m, n, 0, length - 2);
    }

    private static int dfs(
            int[][] grid, int i, int j, int endI, int endJ,
            int m, int n, int curIndex, int pathLength
    ) {
        if (curIndex == pathLength) return (Math.abs(endI - i) + Math.abs(endJ - j) == 1) ? 1 : 0;
        if (i == endI && j == endJ) return 0;
        grid[i][j] = -1;
        int ans = 0;
        if (i > 0 && grid[i - 1][j] == 0) ans += dfs(grid, i - 1, j, endI, endJ, m, n, curIndex + 1, pathLength);
        if (i < m - 1 && grid[i + 1][j] == 0) ans += dfs(grid, i + 1, j, endI, endJ, m, n, curIndex + 1, pathLength);
        if (j > 0 && grid[i][j - 1] == 0) ans += dfs(grid, i, j - 1, endI, endJ, m, n, curIndex + 1, pathLength);
        if (j < n - 1 && grid[i][j + 1] == 0) ans += dfs(grid, i, j + 1, endI, endJ, m, n, curIndex + 1, pathLength);
        grid[i][j] = 0;
        return ans;
    }

    private static boolean checkPossibility(boolean startColor, boolean endColor, int colorDiff) {
        if (startColor != endColor) return colorDiff == 0;
        else return startColor && colorDiff == 1 || !startColor && colorDiff == -1;
    }

    private static boolean checkConnectivity(int[][] grid, int startI, int startJ, int length) {
        int m = grid.length;
        int n = grid[0].length;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(startI, startJ));
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            int i = pair.i;
            int j = pair.j;
            if (grid[i][j] == 0) {
                grid[i][j] = 3;
                length--;
                if (i > 0) stack.push(new Pair(i - 1, j));
                if (i < m - 1) stack.push(new Pair(i + 1, j));
                if (j > 0) stack.push(new Pair(i, j - 1));
                if (j < n - 1) stack.push(new Pair(i, j + 1));
            }
        }
        if (length != 0) return false;
        for (int[] ints : grid) {
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == 3) ints[i] = 0;
            }
        }
        return true;
    }

    private static class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
