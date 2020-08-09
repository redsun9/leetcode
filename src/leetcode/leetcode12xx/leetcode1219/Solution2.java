package leetcode.leetcode12xx.leetcode1219;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Math.max;


/*
    backtrack with memoization
 */

public class Solution2 {
    private static final int[] moves = {1, 0, -1, 0, 1};
    public static final AtomicLong cacheHit = new AtomicLong();
    public static final AtomicLong cacheMiss = new AtomicLong();

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        List<int[]> golds = new ArrayList<>();
        int goldsNumber = 0;
        int[][] index = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    index[i][j] = goldsNumber++;
                    golds.add(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < golds.size(); i++) {
            int[] gold = golds.get(i);
            ans = max(
                    ans,
                    dfs(
                            grid, gold[0], gold[1], m, n,
                            (((long) i) << goldsNumber) | (1L << i), index, goldsNumber, new HashMap<>()
                    )
            );
        }
        return ans;
    }

    private static int dfs(
            int[][] grid, int i, int j, int m, int n,
            long key, int[][] index, int goldsNumber, HashMap<Long, Integer> cache) {
        if (cache.containsKey(key)) {
            cacheHit.incrementAndGet();
            return cache.get(key);
        }
        cacheMiss.incrementAndGet();
        int result = 0;
        int temp = grid[i][j];
        grid[i][j] = 0;

        for (int k = 0; k < 4; k++) {
            int nextI = i + moves[k];
            int nextJ = j + moves[k + 1];
            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && grid[nextI][nextJ] != 0) {
                int ind = index[nextI][nextJ];
                long nextKey = ((1L << goldsNumber) - 1) & key | (1L << ind) | (((long) ind) << goldsNumber);
                result = max(result, temp + dfs(grid, nextI, nextJ, m, n, nextKey, index, goldsNumber, cache));
            }
        }
        if (result == 0) result = temp;
        grid[i][j] = temp;
        cache.put(key, result);
        return result;
    }
}
