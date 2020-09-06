package leetcode.leetcode15xx.leetcode1574;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] arr = {1, 2, 3, 10, 4, 2, 3, 5};
        assertEquals(3, new Solution().findLengthOfShortestSubarray(arr));
    }

    @Test
    void test2() {
        int[] arr = {5, 4, 3, 2, 1};
        assertEquals(4, new Solution().findLengthOfShortestSubarray(arr));
    }

    @Test
    void test3() {
        int[] arr = {1, 2, 3};
        assertEquals(0, new Solution().findLengthOfShortestSubarray(arr));
    }

    @Test
    void test4() {
        int[] arr = {1};
        assertEquals(0, new Solution().findLengthOfShortestSubarray(arr));
    }
}