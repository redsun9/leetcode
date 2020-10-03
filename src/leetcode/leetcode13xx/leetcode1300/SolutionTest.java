package leetcode.leetcode13xx.leetcode1300;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] arr = {4, 9, 3};
        assertEquals(3, new Solution().findBestValue(arr, 10));
        assertEquals(3, new Solution2().findBestValue(arr, 10));
    }

    @Test
    void test2() {
        int[] arr = {2, 3, 5};
        assertEquals(5, new Solution().findBestValue(arr, 10));
        assertEquals(5, new Solution2().findBestValue(arr, 10));
    }

    @Test
    void test3() {
        int[] arr = {60864, 25176, 27249, 21296, 20204};
        assertEquals(11361, new Solution().findBestValue(arr, 56803));
        assertEquals(11361, new Solution2().findBestValue(arr, 56803));
    }

    @Test
    void test4() {
        int[] arr = {1547, 83230, 57084, 93444, 70879};
        assertEquals(17422, new Solution().findBestValue(arr, 71237));
        assertEquals(17422, new Solution2().findBestValue(arr, 71237));
    }

    @Test
    @org.junit.jupiter.api.Disabled
    void testRandom() {
        int[][] tests = generateTests(100_000, 10_000);
        Solution solution1 = new Solution();
        Solution2 solution2 = new Solution2();
        Arrays.stream(tests).parallel()
                .forEach(test -> assertEquals(
                        solution1.findBestValue(test, 100_000),
                        solution2.findBestValue(test, 100_000)
                        )
                );
    }

    //602512000
    //1302905200
    @Test
    @org.junit.jupiter.api.Disabled
    void testPerf() {
        int[][] tests = generateTests(100_000, 10_000);
        Solution solution1 = new Solution();
        Solution2 solution2 = new Solution2();

        long startTime = System.nanoTime();
        Arrays.stream(tests).parallel()
                .forEach(test -> assertTrue(solution1.findBestValue(test, 100_000) > 0));
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        Arrays.stream(tests).parallel()
                .forEach(test -> assertTrue(solution2.findBestValue(test, 100_000) > 0));
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    private int[][] generateTests(int numberOfTests, int testLength) {
        Random random = new Random(0);
        int[][] tests = new int[numberOfTests][testLength];
        for (int[] test : tests)
            for (int i = 0; i < testLength; i++)
                test[i] = random.nextInt(100_000);
        return tests;
    }
}