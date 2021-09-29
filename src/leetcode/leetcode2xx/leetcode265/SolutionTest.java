package leetcode.leetcode2xx.leetcode265;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] costs = {{19, 33, 30}, {30, 26, 14}, {23, 32, 14}, {21, 16, 32}, {16, 30, 30},
                {15, 18, 30}, {21, 21, 21}, {23, 30, 15}, {19, 16, 5}, {17, 20, 30},
                {32, 12, 19}, {18, 8, 31}, {29, 21, 10}, {2, 9, 13}, {31, 30, 22}};
        assertEquals(233, new Solution2().minCostII(costs));
        assertEquals(233, new Solution().minCostII(costs));
    }

    @Test
    void test2() {
        int[][] costs = {{1, 7, 15}, {4, 19, 8}, {6, 9, 20}, {14, 10, 7}, {6, 11, 4}, {8, 5, 8},
                {13, 10, 9}, {1, 5, 15}, {7, 18, 18}, {2, 17, 13}, {14, 12, 6}, {13, 8, 17}, {15, 2, 4},
                {14, 10, 2}, {5, 13, 5}, {11, 18, 4}, {3, 5, 8}, {13, 8, 18}, {7, 5, 3}, {17, 3, 11},
                {3, 4, 5}, {19, 3, 10}, {5, 12, 15}, {12, 2, 9}, {10, 10, 1}, {15, 1, 8}, {15, 8, 8},
                {17, 2, 2}, {3, 11, 20}, {11, 20, 8}, {5, 15, 8}, {6, 2, 14}, {14, 2, 10}, {16, 11, 14},
                {6, 6, 6}, {10, 15, 3}, {4, 11, 14}, {8, 12, 11}, {12, 3, 11}, {16, 19, 14}, {2, 9, 17},
                {2, 18, 17}, {2, 17, 13}, {13, 7, 13}, {3, 11, 9}, {2, 4, 4}, {15, 7, 4}, {16, 8, 20},
                {11, 4, 5}, {11, 10, 1}, {2, 12, 1}, {10, 18, 1}, {11, 13, 4}, {9, 7, 14}, {3, 16, 4},
                {9, 9, 4}, {15, 7, 8}, {3, 7, 14}, {5, 13, 9}, {12, 17, 7}, {9, 5, 1}, {16, 13, 20},
                {17, 7, 1}, {8, 17, 1}, {19, 7, 6}, {16, 4, 18}, {10, 20, 18}, {6, 18, 13}, {19, 11, 20},
                {14, 6, 3}, {14, 9, 13}, {1, 9, 14}, {15, 18, 17}, {8, 6, 4}, {8, 13, 11}, {18, 5, 9},
                {5, 19, 3}, {7, 19, 6}, {10, 11, 14}, {5, 10, 19}, {19, 16, 10}, {16, 12, 17}, {14, 3, 13},
                {18, 11, 12}, {13, 14, 10}, {2, 10, 20}, {16, 4, 5}, {12, 13, 8}, {17, 11, 8}, {12, 15, 17},
                {2, 1, 2}, {17, 17, 12}, {4, 13, 11}, {10, 8, 6}, {11, 20, 6}, {14, 15, 19}, {20, 4, 2},
                {4, 18, 17}, {8, 3, 12}, {5, 3, 9}};
        assertEquals(627, new Solution2().minCostII(costs));
        assertEquals(627, new Solution().minCostII(costs));
    }

    @Test
    void test3() {
        int[][] costs = {{1, 9, 7, 5}, {6, 6, 7, 9}, {6, 1, 3, 4}};
        assertEquals(9, new Solution2().minCostII(costs));
        assertEquals(9, new Solution().minCostII(costs));
    }


    @Test
    @Disabled
    void randomTest() throws InterruptedException {
        int n = 10, k = 5, maxVal = 20;
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        StressTester.exactStressTest(
                seed -> {
                    int[][] costs = new int[n][k];
                    Random random = new Random(seed);
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < k; j++) {
                            costs[i][j] = 1 + random.nextInt(maxVal);
                        }
                    }
                    return costs;
                },
                solution2::minCostII,
                solution::minCostII
        );
    }
}