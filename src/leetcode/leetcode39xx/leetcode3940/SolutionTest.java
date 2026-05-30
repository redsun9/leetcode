package leetcode.leetcode39xx.leetcode3940;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void limitOccurrences() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expected = {1, 1, 2, 2, 3};
        assertArrayEquals(expected, new Solution().limitOccurrences(nums, k));
    }
}