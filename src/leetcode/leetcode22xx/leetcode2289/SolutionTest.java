package leetcode.leetcode22xx.leetcode2289;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test1() {
        int[] nums = {5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11};
        assertEquals(3, new Solution().totalSteps(nums));
    }

    @Test
    void test2() {
        int[] nums = {4, 5, 7, 7, 13};
        assertEquals(0, new Solution().totalSteps(nums));
    }

    @Test
    @Disabled
    void testCorrectness() throws InterruptedException {
        int n = 1000, maxVal = 100;
        Solution solution = new Solution();
        Solution3 solution2 = new Solution3();
        StressTester.exactStressTest(
                seed -> {
                    int[] nums = new int[n];
                    Random random = new Random(seed);
                    for (int i = 0; i < n; i++) nums[i] = random.nextInt(maxVal);
                    return nums;
                },
                solution::totalSteps,
                solution2::totalSteps,
                1_000_000,
                1,
                100_000
        );
    }
}