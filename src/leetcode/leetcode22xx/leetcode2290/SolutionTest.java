package leetcode.leetcode22xx.leetcode2290;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

class SolutionTest {
    @Test
    @Disabled
    void testRandom() throws InterruptedException {
        int m = 20, n = 20;
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        StressTester.exactStressTest(
                seed -> {
                    int[][] grid = new int[m][n];
                    Random rand = new Random(seed);
                    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) grid[i][j] = rand.nextInt(2);
                    return grid;
                },
                solution::minimumObstacles,
                solution2::minimumObstacles,
                1_000_000,
                1,
                100_000
        );
    }
}