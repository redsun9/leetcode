package leetcode.leetcode8xx.leetcode805;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        assertTrue(solution.splitArraySameAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        assertFalse(solution.splitArraySameAverage(new int[]{3, 1}));
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        assertTrue(solution.splitArraySameAverage(new int[]{5, 3, 11, 19, 2}));
    }

    @Test
    void perfTest() {
        Solution solution = new Solution();
        Random random = new Random(0);
        int testNumber = 1_000_000;
        int testLength = 30;
        int[][] suitcase = new int[testNumber][testLength];
        for (int i = 0; i < testNumber; i++) {
            for (int j = 0; j < testLength; j++) {
                suitcase[i][j] = random.nextInt(10000);
            }
        }
        long startTime = System.nanoTime();
        IntStream.range(0, testNumber).parallel().forEach(i -> solution.splitArraySameAverage(suitcase[i]));
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1_000_000);
    }
}