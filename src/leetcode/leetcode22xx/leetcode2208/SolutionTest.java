package leetcode.leetcode22xx.leetcode2208;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {5, 19, 8, 1};
        assertEquals(3, new Solution().halveArray(nums));
    }

    @Test
    void test2() {
        int[] nums = {3, 8, 20};
        assertEquals(3, new Solution().halveArray(nums));
    }
}