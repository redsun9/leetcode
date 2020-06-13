package leetcode.leetcode13xx.leetcode1391;

public class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) return true;
        if (grid[0][0] == 5) return false;
        if (
                n > 1 && (grid[0][0] == 1 || grid[0][0] == 4 || grid[0][0] == 6)
                        && (grid[0][1] == 1 || grid[0][1] == 3) &&
                        check(0, 1, grid, m, n, From.LEFT)
        ) return true;
        if (
                m > 1 && (grid[0][0] == 2 || grid[0][0] == 3 || grid[0][0] == 4)
                        && (grid[1][0] == 2 || grid[1][0] == 6) &&
                        check(1, 0, grid, m, n, From.TOP)
        ) return true;
        return false;
    }

    private static boolean check(int i, int j, int[][] grid, int m, int n, From from) {
        while ((i != m - 1 || j != n - 1) && (i != 0 || j != 0)) {
            if (from == From.LEFT) {
                if (grid[i][j] == 1) {
                    if (!canGetFromLeft(i, j + 1, m, n, grid)) break;
                    j++;
                } else if (grid[i][j] == 3) {
                    if (!canGetFromTop(i + 1, j, m, n, grid)) break;
                    i++;
                    from = From.TOP;
                } else if (grid[i][j] == 5) {
                    if (!canGetFromBottom(i - 1, j, m, n, grid)) break;
                    i--;
                    from = From.BOTTOM;
                }
            } else if (from == From.RIGHT) {
                if (grid[i][j] == 1) {
                    if (!canGetFromRight(i, j - 1, m, n, grid)) break;
                    j--;
                } else if (grid[i][j] == 4) {
                    if (!canGetFromTop(i + 1, j, m, n, grid)) break;
                    i++;
                    from = From.TOP;
                } else if (grid[i][j] == 6) {
                    if (!canGetFromBottom(i - 1, j, m, n, grid)) break;
                    i--;
                    from = From.BOTTOM;
                }
            } else if (from == From.TOP) {
                if (grid[i][j] == 2) {
                    if (!canGetFromTop(i + 1, j, m, m, grid)) break;
                    i++;
                } else if (grid[i][j] == 5) {
                    if (!canGetFromRight(i, j - 1, m, n, grid)) break;
                    j--;
                    from = From.RIGHT;
                } else if (grid[i][j] == 6) {
                    if (!canGetFromLeft(i, j + 1, m, n, grid)) break;
                    j++;
                    from = From.LEFT;
                }
            } else {
                if (grid[i][j] == 2) {
                    if (!canGetFromBottom(i - 1, j, m, n, grid)) break;
                    i--;
                } else if (grid[i][j] == 3) {
                    if (!canGetFromRight(i, j - 1, m, n, grid)) break;
                    j--;
                    from = From.RIGHT;
                } else if (grid[i][j] == 4) {
                    if (!canGetFromLeft(i, j + 1, m, n, grid)) break;
                    j++;
                    from = From.LEFT;
                }
            }
        }
        return i == m - 1 && j == n - 1;
    }

    private static boolean canGetFromLeft(int i, int j, int m, int n, int[][] grid) {
        return j < n && (grid[i][j] == 1 || grid[i][j] == 3 || grid[i][j] == 5);
    }

    private static boolean canGetFromRight(int i, int j, int m, int n, int[][] grid) {
        return j >= 0 && (grid[i][j] == 1 || grid[i][j] == 4 || grid[i][j] == 6);
    }

    private static boolean canGetFromTop(int i, int j, int m, int n, int[][] grid) {
        return i < m && (grid[i][j] == 2 || grid[i][j] == 5 || grid[i][j] == 6);
    }

    private static boolean canGetFromBottom(int i, int j, int m, int n, int[][] grid) {
        return i >= 0 && (grid[i][j] == 2 || grid[i][j] == 3 || grid[i][j] == 4);
    }

    enum From {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }
}
