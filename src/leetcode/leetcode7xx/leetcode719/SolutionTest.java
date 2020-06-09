package leetcode.leetcode7xx.leetcode719;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 3, 1};
        assertEquals(0, new Solution().smallestDistancePair(nums, 1));
        assertEquals(0, new Solution2().smallestDistancePair(nums, 1));
    }

    @Test
    void test2() {
        int[] nums = {9, 10, 7, 10, 6, 1, 5, 4, 9, 8};
        assertEquals(2, new Solution().smallestDistancePair(nums, 18));
        assertEquals(2, new Solution2().smallestDistancePair(nums, 18));
    }


    @Test
    void perfTest() {
        Random random = new Random(0);
        int numberOfTests = 1000;
        int maxA = 1_000_000_000;
        int L = 10_000;
        int K = 1_000_000;
        int[][] a = new int[numberOfTests][L];
        int[][] b = new int[numberOfTests][L];
        for (int i = 0; i < numberOfTests; i++) {
            for (int j = 0; j < L; j++) {
                a[i][j] = random.nextInt(maxA);
                b[i][j] = a[i][j];
            }
            Arrays.sort(a[i]);
            Arrays.sort(b[i]);
        }
        Solution first = new Solution();
        Solution2 second = new Solution2();

        long start = System.nanoTime();
        IntStream.range(0, numberOfTests).parallel().forEach(i ->
                assertTrue(first.smallestDistancePair(a[i], K) >= 0)
        );
        long end = System.nanoTime();
        System.out.println(end - start);

        start = System.nanoTime();
        IntStream.range(0, numberOfTests).parallel().forEach(i ->
                assertTrue(second.smallestDistancePair(b[i], K) >= 0)
        );
        end = System.nanoTime();
        System.out.println(end - start);
    }
}