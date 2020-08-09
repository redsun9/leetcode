package leetcode.leetcode12xx.leetcode1219;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    int[][][] prepareTests(int numberOfTests, int m, int n, int gold) {
        Random random = new Random();
        int[][][] tests = new int[numberOfTests][m][n];
        for (int t = 0; t < numberOfTests; t++) {
            int goldLeft = gold;
            while (goldLeft > 0) {
                int i = random.nextInt(m);
                int j = random.nextInt(n);
                if (tests[t][i][j] == 0) {
                    tests[t][i][j] = 1 + random.nextInt(1000);
                    goldLeft--;
                }
            }
        }
        return tests;
    }

    @Test
    void test() {
        int[][][] tests = prepareTests(100, 6, 6, 25);
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        IntStream.range(0, tests.length).parallel().forEach(
                t -> assertEquals(solution.getMaximumGold(tests[t]), solution2.getMaximumGold(tests[t]))
        );
    }

    /*
    13522779081 - dfs
    244616997143 - dfs with memoization
    80423969 - cache hit count
    1252039616 - cache miss count
     */
    @Test
    void perfTest() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        int[][][] tests = prepareTests(10, 8, 8, 50);

        long startTime = System.nanoTime();
        IntStream.range(0, tests.length).parallel().forEach(
                t -> solution.getMaximumGold(tests[t])
        );
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        IntStream.range(0, tests.length).parallel().forEach(
                t -> solution2.getMaximumGold(tests[t])
        );
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        System.out.println(Solution2.cacheHit.get());
        System.out.println(Solution2.cacheMiss.get());
    }
}
