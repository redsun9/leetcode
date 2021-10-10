package leetcode.leetcode20xx.leetcode2035;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("DuplicatedCode")
class SolutionTest {

    @Test
    void test1() {
        int[] nums = {3, 9, 7, 3};
        assertEquals(2, new Solution().minimumDifference(nums));
        assertEquals(2, new Solution2().minimumDifference(nums));
        assertEquals(2, new Solution3().minimumDifference(nums));
    }

    @Test
    void test2() {
        int[] nums = {2, -1, 0, 4, -2, -9};
        assertEquals(0, new Solution().minimumDifference(nums));
        assertEquals(0, new Solution2().minimumDifference(nums));
        assertEquals(0, new Solution3().minimumDifference(nums));
    }

    @Test
    void test3() {
        int[] nums = {0, 6, 11, 17, 18, 24};
        assertEquals(6, new Solution().minimumDifference(nums));
        assertEquals(6, new Solution2().minimumDifference(nums));
        assertEquals(6, new Solution3().minimumDifference(nums));
    }

    @Test
    void testSolution() throws InterruptedException {
        int n = 10;
        int minValue = -1_000_000, maxValue = 1_000_000;
        Solution solution = new Solution();
        Solution3 solution3 = new Solution3();
        assertTrue(StressTester.exactStressTest(
                seed -> {
                    int[] nums = new int[n];
                    Random random = new Random(seed);
                    for (int i = 0; i < n; i++) nums[i] = minValue + random.nextInt(maxValue - minValue + 1);
                    return nums;
                },
                solution3::minimumDifference,
                solution::minimumDifference,
                1_000
        ));
    }

    @Test
    void testSolution2() throws InterruptedException {
        int n = 10;
        int minValue = -1_000_000, maxValue = 1_000_000;
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        assertTrue(StressTester.exactStressTest(
                seed -> {
                    int[] nums = new int[n];
                    Random random = new Random(seed);
                    for (int i = 0; i < n; i++) nums[i] = minValue + random.nextInt(maxValue - minValue + 1);
                    return nums;
                },
                solution3::minimumDifference,
                solution2::minimumDifference,
                1_000
        ));
    }
}