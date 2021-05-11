package leetcode.leetcode18xx.leetcode1846;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] arr = {2, 2, 1, 2, 1};
        assertEquals(2, new Solution().maximumElementAfterDecrementingAndRearranging(arr));
    }

    @Test
    void test2() {
        int[] arr = {100, 1, 1000};
        assertEquals(3, new Solution().maximumElementAfterDecrementingAndRearranging(arr));
    }

    @Test
    void test3() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(5, new Solution().maximumElementAfterDecrementingAndRearranging(arr));
    }

    @Test
    void test4() {
        int[] arr = {3, 3, 3, 3, 3, 3, 3, 3, 3, 1000, 3, 3, 3};
        assertEquals(4, new Solution().maximumElementAfterDecrementingAndRearranging(arr));
    }
}