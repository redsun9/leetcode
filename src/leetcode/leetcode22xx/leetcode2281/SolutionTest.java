package leetcode.leetcode22xx.leetcode2281;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 3, 1, 2};
        assertEquals(44, new Solution().totalStrength(nums));
    }

    @Test
    void test2() {
        int[] nums = {5, 4, 6};
        assertEquals(213, new Solution().totalStrength(nums));
    }

    @Test
    @Disabled
    void testCorrectness() throws InterruptedException {
        int n = 10, MAX_VAL = 100;
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        StressTester.exactStressTest(
                seed -> {
                    int[] nums = new int[n];
                    Random random = new Random(seed);
                    for (int i = 0; i < n; i++) nums[i] = 1 + random.nextInt(MAX_VAL);
                    return nums;
                },
                solution2::totalStrength,
                solution::totalStrength,
                1_000_000,
                1,
                100_000
        );
    }
}