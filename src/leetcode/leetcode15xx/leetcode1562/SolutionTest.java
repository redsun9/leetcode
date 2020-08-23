package leetcode.leetcode15xx.leetcode1562;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] arr = {3, 5, 1, 2, 4};
        int m = 1;
        assertEquals(4, new Solution().findLatestStep(arr, m));
    }

    @Test
    void test2() {
        int[] arr = {3, 1, 5, 4, 2};
        int m = 2;
        assertEquals(-1, new Solution().findLatestStep(arr, m));
    }

    @Test
    void test3() {
        int[] arr = {1};
        int m = 1;
        assertEquals(1, new Solution().findLatestStep(arr, m));
    }

    @Test
    void test4() {
        int[] arr = {2, 1};
        int m = 2;
        assertEquals(2, new Solution().findLatestStep(arr, m));
    }
}