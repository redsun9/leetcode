package leetcode.leetcode18xx.leetcode1828;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] points = {{1, 3}, {3, 3}, {5, 3}, {2, 2}}, queries = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        int[] expected = {3, 2, 2};
        assertArrayEquals(expected, new Solution().countPoints(points, queries));
    }

    @Test
    void test2() {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}, queries = {{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}};
        int[] expected = {2, 3, 2, 4};
        assertArrayEquals(expected, new Solution().countPoints(points, queries));
    }

    @Test
    @Disabled
    void testRandom() {
        int numberOfTests = 1000;
        int numberOfPoints = 1000;
        int numberOfQueries = 1000;
        IntStream.range(0, numberOfTests).parallel().forEach(t -> {
            Random random = ThreadLocalRandom.current();
            int[][] testPoints = new int[numberOfPoints][2];
            int[][] testQueries = new int[numberOfQueries][3];
            for (int j = 0; j < numberOfPoints; j++) {
                testPoints[j][0] = random.nextInt(501);
                testPoints[j][1] = random.nextInt(501);
            }
            for (int j = 0; j < numberOfQueries; j++) {
                testQueries[j][0] = random.nextInt(501);
                testQueries[j][1] = random.nextInt(501);
                testQueries[j][2] = 1 + random.nextInt(500);
            }
            assertArrayEquals(
                    new Solution().countPoints(testPoints, testQueries),
                    new Solution2().countPoints(testPoints, testQueries)
            );
        });
    }

    @Test
    @Disabled
    void testPerf() {
        int numberOfTests = 10;
        int numberOfPoints = 1000000;
        int numberOfQueries = 1000;
        Random random = new Random(0);
        int[][][] testPoints = new int[numberOfTests][numberOfPoints][2];
        int[][][] testQueries = new int[numberOfTests][numberOfQueries][3];
        for (int i = 0; i < numberOfTests; i++) {
            for (int j = 0; j < numberOfPoints; j++) {
                testPoints[i][j][0] = random.nextInt(501);
                testPoints[i][j][1] = random.nextInt(501);
            }
            for (int j = 0; j < numberOfQueries; j++) {
                testQueries[i][j][0] = random.nextInt(501);
                testQueries[i][j][1] = random.nextInt(501);
                testQueries[i][j][2] = 1 + random.nextInt(500);
            }
        }

        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        int[][] expected = new int[numberOfTests][];
        int[][] actual = new int[numberOfTests][];

        long startTime = System.nanoTime();
        IntStream.range(0, numberOfTests).parallel().forEach(t -> {
            expected[t] = solution.countPoints(testPoints[t], testQueries[t]);
        });
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        IntStream.range(0, numberOfTests).parallel().forEach(t -> {
            actual[t] = solution2.countPoints(testPoints[t], testQueries[t]);
        });
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        for (int i = 0; i < numberOfTests; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }
}