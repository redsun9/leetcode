package leetcode.leetcode21xx.leetcode2184;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"DuplicatedCode", "unchecked"})
public class Solution2 {
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
        List<Integer>[] mat = new List[n];
        for (int i = 0; i < n; i++) mat[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((possibleRows.get(i) & possibleRows.get(j)) == 0) {
                    mat[i].add(j);
                    if (i != j) mat[j].add(i);
                }
            }
        }
        int[] prev = new int[n], curr = new int[n], tmp;
        Arrays.fill(prev, 1);

        for (int h = 1; h < height; h++) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (Integer j : mat[i]) {
                    sum += prev[j];
                    if (sum >= p) sum -= p;
                }
                curr[i] = sum;
            }
            tmp = prev;
            prev = curr;
            curr = tmp;
        }

        int ans = 0;
        for (int val : prev) {
            ans += val;
            if (ans >= p) ans -= p;
        }

        return ans;
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
            if ((parallelKey & brickMask) != 0) rows.add((key & ~(1 << width)) >> 1);
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
}
