package leetcode.leetcode14xx.leetcode1477;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] arr = {3, 2, 2, 4, 3};
        assertEquals(2, new Solution().minSumOfLengths(arr, 3));
    }

    @Test
    void test2() {
        int[] arr = {7, 3, 4, 7};
        assertEquals(2, new Solution().minSumOfLengths(arr, 7));
    }

    @Test
    void test3() {
        int[] arr = {4, 3, 2, 6, 2, 3, 4};
        assertEquals(-1, new Solution().minSumOfLengths(arr, 6));
    }

    @Test
    void test4() {
        int[] arr = {5, 5, 4, 4, 5};
        assertEquals(-1, new Solution().minSumOfLengths(arr, 3));
    }

    @Test
    void test5() {
        int[] arr = {3, 1, 1, 1, 5, 1, 2, 1};
        assertEquals(3, new Solution().minSumOfLengths(arr, 3));
    }

    @Test
    void test6() {
        int[] arr = {64, 5, 20, 9, 1, 39};
        assertEquals(6, new Solution().minSumOfLengths(arr, 69));
    }

}