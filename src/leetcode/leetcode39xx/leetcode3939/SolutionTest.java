package leetcode.leetcode39xx.leetcode3939;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test1() {
        int[] parent = {-1, 0, 1}, nums = {1, 2, 3};
        int k = 3;
        assertEquals(1, new Solution().countValidSubsets(parent, nums, k));
    }

    @Test
    void test2() {
        int[] parent = {-1, 0, 0, 0}, nums = {2, 1, 2, 1};
        int k = 3;
        assertEquals(2, new Solution().countValidSubsets(parent, nums, k));
    }
}