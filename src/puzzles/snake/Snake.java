package puzzles.snake;

import java.util.Arrays;

public class Snake {

    private static final int[] moves = {1, 0, -1, 0, 1};

    public static int solve(int n) {
        int[][] tmp = new int[n][n];
        boolean[][] rows = new boolean[n][n], cols = new boolean[n][n];
        int ans = 0;
        for (int i = 0, leftI = n; i < leftI; i++, leftI--) {
            for (int j = 0; j <= i; j++) {
                ans = Math.max(ans, dfs(1, i, j, n, tmp, rows, cols, ans));
            }
        }
        return ans;
    }

    private static int dfs(int i, int x, int y, int n, int[][] tmp, boolean[][] rows, boolean[][] cols, int max) {
        int ans = Math.max(max, i), curVal = 1 + ((i - 1) % n), nextVal = 1 + i % n;
        tmp[x][y] = i;
        rows[x][curVal - 1] = true;
        cols[y][curVal - 1] = true;
        boolean found = false;
        for (int k = 0; k < 4; k++) {
            int newX = x + moves[k], newY = y + moves[k + 1];
            if (newX < 0 || newX == n || newY < 0 || newY == n) continue;
            if (tmp[newX][newY] != 0 || rows[newX][nextVal - 1] || cols[newY][nextVal - 1]) continue;
            found = true;
            ans = Math.max(ans, dfs(i + 1, newX, newY, n, tmp, rows, cols, ans));
        }

        if (!found && ans > max) {
            for (int[] row : tmp) System.out.println(Arrays.toString(row));
            System.out.println();
        }

        tmp[x][y] = 0;
        rows[x][curVal - 1] = false;
        cols[y][curVal - 1] = false;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(5));
        System.out.println(solve(7));
    }
}


//[1, 0, 5, 6, 9, 10, 11]
//[2, 3, 4, 7, 8, 13, 12]
//[0, 0, 37, 38, 0, 14, 15]
//[0, 35, 36, 39, 20, 19, 16]
//[33, 34, 0, 22, 21, 18, 17]
//[32, 29, 28, 23, 24, 0, 0]
//[31, 30, 27, 26, 25, 0, 0]

//[2, 3, 4, 5, 42, 43, 44, 45, 46]
//[1, 8, 7, 6, 41, 40, 0, 48, 47]
//[0, 9, 10, 0, 38, 39, 50, 49, 0]
//[0, 0, 11, 36, 37, 0, 51, 52, 53]
//[14, 13, 12, 35, 34, 33, 56, 55, 54]
//[15, 16, 17, 0, 31, 32, 57, 0, 0]
//[0, 19, 18, 29, 30, 0, 58, 59, 0]
//[21, 20, 0, 28, 27, 62, 61, 60, 67]
//[22, 23, 24, 25, 26, 63, 64, 65, 66]