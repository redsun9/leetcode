package leetcode.leetcode39xx.leetcode3936;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {0, 1, 0, 3, 12};
        assertEquals(2, new Solution().minimumSwaps(nums));
    }

    @Test
    void test2() {
        int[] nums = {0, 1, 0, 2};
        assertEquals(1, new Solution().minimumSwaps(nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 0};
        assertEquals(0, new Solution().minimumSwaps(nums));
    }
}