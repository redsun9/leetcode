package leetcode.leetcode21xx.leetcode2184;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public static final int p = 1_000_000_007;

    public int buildWall(int height, int width, int[] bricks) {
        if (height == 1) return onlyCount(width, bricks);
        //we will use it to reduce steps in dfs
        Arrays.sort(bricks);

        //create mask for possible cell we could arrive from
        int brickMask = 0;
        int maxBrick = 0;
        for (int brick : bricks) {
            if (brick > width) break;
            brickMask |= 1 << brick;
            maxBrick = brick;
        }
        int maxBrickMask = (2 << maxBrick) - 1;

        //find all possible ways to build one row
        //except ways that can't be followed by any possible way
        List<Integer> possibleRows = new ArrayList<>();
        dfs(width, 0, 1, bricks, possibleRows, 1, brickMask, maxBrickMask);
        int n = possibleRows.size();

        //create matrix mat[i][j]==1 if row[i] may follow row[j]
        long[][] mat = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((possibleRows.get(i) & possibleRows.get(j)) == 0) {
                    mat[i][j] = 1;
                    mat[j][i] = 1;
                }
            }
        }
        //we use fast matrix power
        long[][] matrixPower = matrixPower(mat, height - 1);
        long ans = 0;
        for (long[] row : matrixPower) {
            for (long num : row) {
                ans += num;
                if (ans >= p) ans -= p;
            }
        }
        return (int) ans;
    }

    //this method only for height of 1, and counts all possible ways to build row
    private static int onlyCount(int n, int[] bricks) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int tmp = 0;
            for (int brick : bricks) {
                if (brick <= i) {
                    tmp += dp[i - brick];
                    if (tmp >= p) tmp -= p;
                }
            }
            dp[i] = tmp;
        }
        return dp[n];
    }

    //parallel key's bits represents is it possible to create a sub-row for previous lengths
    private static void dfs(
            int width, int curWidth, int key, int[] bricks, List<Integer> rows,
            int parallelKey, int brickMask, int maxBrickMask
    ) {
        if (curWidth == width) {
            //we have built row, and now we check if there is any possible other row that could follow this one
            if ((parallelKey & brickMask) != 0) rows.add(key & ~(1 << width) & ~1);
            return;
        }

        int prevBrick = 0;
        for (int brick : bricks) {
            //bricks sorted by their length, so we can reduce number of operations for updating parallel key
            int newWidth = curWidth + brick;
            if (newWidth <= width) {
                parallelKey = updateKey(parallelKey, brick - prevBrick - 1, brickMask);
                if ((parallelKey << 1 & maxBrickMask) != 0) {
                    dfs(width, newWidth, key | 1 << newWidth, bricks, rows, parallelKey << 1, brickMask, maxBrickMask);
                }
                prevBrick = brick;
                parallelKey = updateKey(parallelKey, 1, brickMask);
            }
        }

    }

    private static int updateKey(int key, int times, int brickMask) {
        for (int i = 0; i < times; i++) {
            key <<= 1;
            if ((key & brickMask) != 0) key |= 1;
        }
        return key;
    }

    private static long[][] matrixPower(long[][] base, long pow) {
        int n = base.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }
        while (pow != 0) {
            if ((pow & 1) != 0) {
                res = multiplyMatrix(res, base);
                --pow;
            } else {
                base = multiplyMatrix(base, base);
                pow >>= 1;
            }
        }
        return res;
    }

    private static long[][] multiplyMatrix(long[][] a, long[][] b) {
        int n = a.length;
        long[][] ans = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                    if (ans[i][j] >= p) ans[i][j] %= p; // remove if not modular
                }
            }
        }
        return ans;
    }
}
