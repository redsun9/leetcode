package leetcode.leetcode17xx.leetcode1703;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 0, 0, 1, 0, 1};
        int k = 2;
        assertEquals(1, new Solution().minMoves(nums, k));
        assertEquals(1, new Solution2().minMoves(nums, k));
    }

    @Test
    void test2() {
        int[] nums = {1, 0, 0, 0, 0, 0, 1, 1};
        int k = 3;
        assertEquals(5, new Solution().minMoves(nums, k));
        assertEquals(5, new Solution2().minMoves(nums, k));
    }

    @Test
    void test3() {
        int[] nums = {1, 1, 0, 1};
        int k = 2;
        assertEquals(0, new Solution().minMoves(nums, k));
        assertEquals(0, new Solution2().minMoves(nums, k));
    }

    @Test
    void test4() {
        int[] nums = {0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0};
        int k = 7;
        assertEquals(4, new Solution().minMoves(nums, k));
        assertEquals(4, new Solution2().minMoves(nums, k));
    }

    @Test
    void test5() {
        int[] nums = {0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0};
        int k = 26;
        assertEquals(119, new Solution().minMoves(nums, k));
        assertEquals(119, new Solution2().minMoves(nums, k));
    }
}