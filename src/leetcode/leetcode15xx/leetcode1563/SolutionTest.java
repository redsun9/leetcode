package leetcode.leetcode15xx.leetcode1563;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] stones = {6, 2, 3, 4, 5, 5};
        assertEquals(18, new Solution().stoneGameV(stones));
        assertEquals(18, new Solution3().stoneGameV(stones));
    }

    @Test
    void test2() {
        int[] stones = {7, 7, 7, 7, 7, 7, 7};
        assertEquals(28, new Solution().stoneGameV(stones));
        assertEquals(28, new Solution3().stoneGameV(stones));
    }

    @Test
    void test3() {
        int[] stones = {4};
        assertEquals(0, new Solution().stoneGameV(stones));
        assertEquals(0, new Solution3().stoneGameV(stones));
    }

    @Test
    void test5() {
        int[] stones = {1, 2, 4, 8, 6, 7, 2};
        assertEquals(26, new Solution().stoneGameV(stones));
        assertEquals(26, new Solution3().stoneGameV(stones));
    }

    @Test
    void test6() {
        int[] stones = {4, 2, 7, 7, 1, 1, 4};
        assertEquals(22, new Solution().stoneGameV(stones));
        assertEquals(22, new Solution3().stoneGameV(stones));
    }

    @Test
    void test7() {
        int[] stones = {98, 77, 24, 49, 6, 12, 2, 44, 51, 96};
        assertEquals(330, new Solution().stoneGameV(stones));
        assertEquals(330, new Solution3().stoneGameV(stones));
    }

    @Test
    void test8() {
        // counterexample to greedy solution
        // cause f([10,2,8])=12, while f([10,2,8,1]) = 10
        int[] stones = {10, 2, 8, 1, 6, 8, 10};
        assertEquals(32, new Solution().stoneGameV(stones));
        assertEquals(31, new Solution2().stoneGameV(stones));
        assertEquals(32, new Solution3().stoneGameV(stones));
    }

    @Test
    void testRandom() {
        Random random = new Random(0);
        int numberOfTests = 1000;
        int lengthOftests = 500;
        int[][] tests = new int[numberOfTests][lengthOftests];
        for (int i = 0; i < numberOfTests; i++) {
            for (int j = 0; j < lengthOftests; j++) {
                tests[i][j] = 1 + random.nextInt(100);
            }
        }
        Solution solution = new Solution();
        Solution3 solution3 = new Solution3();
        IntStream.range(0, numberOfTests).parallel().forEach(i -> assertEquals(solution.stoneGameV(tests[i]), solution3.stoneGameV(tests[i])));
    }

    @Test
    void testPerf() {
        Random random = new Random(0);
        int numberOfTests = 1000;
        int lengthOftests = 500;
        int[][] tests = new int[numberOfTests][lengthOftests];
        for (int i = 0; i < numberOfTests; i++) {
            for (int j = 0; j < lengthOftests; j++) {
                tests[i][j] = 1 + random.nextInt(100);
            }
        }
        Solution solution = new Solution();
        Solution3 solution3 = new Solution3();
        long startTime = System.nanoTime();
        IntStream.range(0, numberOfTests).parallel().forEach(i -> assertTrue(solution.stoneGameV(tests[i]) > 0));
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        IntStream.range(0, numberOfTests).parallel().forEach(i -> assertTrue(solution3.stoneGameV(tests[i]) > 0));
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

    }
}