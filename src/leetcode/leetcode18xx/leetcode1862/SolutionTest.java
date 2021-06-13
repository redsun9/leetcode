package leetcode.leetcode18xx.leetcode1862;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {2, 5, 9};
        assertEquals(10, new Solution().sumOfFlooredPairs(nums));
    }

    @Test
    void test2() {
        int[] nums = {7, 7, 7, 7, 7, 7, 7};
        assertEquals(49, new Solution().sumOfFlooredPairs(nums));
    }

    @Test
    void test3() {
        int[] nums = {60, 99, 20, 52, 13};
        assertEquals(33, new Solution().sumOfFlooredPairs(nums));
    }

    @Test
    void test4() {
        int[] nums = new int[100_000];
        Arrays.fill(nums, 1);
        nums[nums.length - 1] = 100000;
        assertEquals(999699869, new Solution().sumOfFlooredPairs(nums));
    }

    @Test
    @Disabled
    void testRandom() {
        int maxValue = 100000;
        int numberOfTests = 1000;
        int testLength = 1000;
        int p = 1_000_000_007;
        int[][] tests = new int[numberOfTests][testLength];
        long[] expected = new long[numberOfTests];
        IntStream.range(0, numberOfTests).parallel().forEach(t -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            int[] test = tests[t];
            for (int i = 0; i < testLength; i++) {
                test[i] = 1 + random.nextInt(maxValue);
            }
            for (int i = 0; i < testLength; i++) {
                for (int j = 0; j < testLength; j++) {
                    expected[t] += test[i] / test[j];
                }
            }
        });
        Solution solution = new Solution();
        IntStream.range(0, numberOfTests).parallel().forEach(t -> {
            try {
                assertEquals((int) (expected[t] % p), solution.sumOfFlooredPairs(tests[t]));
            } catch (Throwable e) {
                System.out.println(Arrays.toString(tests[t]));
                System.out.println(expected[t]);
                throw e;
            }
        });
    }
}