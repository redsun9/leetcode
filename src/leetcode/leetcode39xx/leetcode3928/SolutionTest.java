package leetcode.leetcode39xx.leetcode3928;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int n = 2;
        int[] prices = {8, 3};
        int[][] roads = {{0, 1, 1, 2}};
        int[] expected = {6, 3};
        assertArrayEquals(expected, new Solution().minCost(n, prices, roads));
        assertArrayEquals(expected, new Solution2().minCost(n, prices, roads));
    }

    @Test
    void test2() {
        int n = 3;
        int[] prices = {9, 4, 6};
        int[][] roads = {{0, 1, 1, 3}, {1, 2, 4, 2}};
        int[] expected = {8, 4, 6};
        assertArrayEquals(expected, new Solution().minCost(n, prices, roads));
        assertArrayEquals(expected, new Solution2().minCost(n, prices, roads));
    }

    @Test
    void test3() {
        int n = 3;
        int[] prices = {10, 11, 1};
        int[][] roads = {{0, 2, 1, 3}, {1, 2, 3, 4}, {0, 1, 5, 2}};
        int[] expected = {5, 11, 1};
        assertArrayEquals(expected, new Solution().minCost(n, prices, roads));
        assertArrayEquals(expected, new Solution2().minCost(n, prices, roads));
    }

    @Test
    void test4() throws InterruptedException {
        assertTrue(StressTester.exactStressTest(
                seed -> {
                    int n = 10;
                    Random random = new Random(seed);
                    int[] prices = new int[n];
                    for (int i = 0; i < n; i++) prices[i] = random.nextInt(1, 1000);
                    int[][] roads = new int[n * (n - 1) / 2][4];
                    for (int i = 0, p = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            roads[p++] = new int[]{i, j, random.nextInt(1, 100), random.nextInt(1, 5)};
                        }
                    }
                    return new TestData(n, prices, roads);
                },
                testData -> new Solution().minCost(testData.n, testData.prices, testData.roads),
                testData -> new Solution2().minCost(testData.n, testData.prices, testData.roads),
                100_000,
                1,
                10_000
        ));
    }

    private record TestData(int n, int[] prices, int[][] roads) {
    }
}