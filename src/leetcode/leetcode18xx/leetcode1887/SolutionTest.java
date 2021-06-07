package leetcode.leetcode18xx.leetcode1887;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {5, 1, 3};
        assertEquals(3, new Solution().reductionOperations(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 1, 1};
        assertEquals(0, new Solution().reductionOperations(nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 1, 2, 2, 3};
        assertEquals(4, new Solution().reductionOperations(nums));
    }
}