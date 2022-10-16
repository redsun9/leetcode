package leetcode.leetcode24xx.leetcode2440;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {6, 2, 2, 2, 6};
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        assertEquals(2, new Solution().componentValue(nums, edges));
    }
}