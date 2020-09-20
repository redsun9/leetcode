package leetcode.leetcode15xx.leetcode1589;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 3, 4, 5};
        int[][] requests = {{1, 3}, {0, 1}};
        assertEquals(19, new Solution().maxSumRangeQuery(nums, requests));
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[][] requests = {{0, 1}};
        assertEquals(11, new Solution().maxSumRangeQuery(nums, requests));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3, 4, 5, 10};
        int[][] requests = {{0, 2}, {1, 3}, {1, 1}};
        assertEquals(47, new Solution().maxSumRangeQuery(nums, requests));
    }

    @Test
    void test4() {
        int[] nums = {1, 8, 5, 5, 2};
        int[][] requests = {{4, 4}, {3, 4}, {4, 4}, {2, 4}, {0, 0}};
        assertEquals(49, new Solution().maxSumRangeQuery(nums, requests));
    }
}
