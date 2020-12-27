package leetcode.leetcode16xx.leetcode1673;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {3, 5, 2, 6};
        int[] expected = {2, 6};
        assertArrayEquals(expected, new Solution().mostCompetitive(nums, 2));
    }

    @Test
    void test2() {
        int[] nums = {2, 4, 3, 3, 5, 4, 9, 6};
        int[] expected = {2, 3, 3, 4};
        assertArrayEquals(expected, new Solution().mostCompetitive(nums, 4));
    }
}