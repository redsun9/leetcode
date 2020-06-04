package leetcode.leetcode13xx.leetcode1375;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] a = {2, 1, 3, 5, 4};
        assertEquals(3, new Solution().numTimesAllBlue(a));
    }

    @Test
    void test2() {
        int[] a = {3, 2, 4, 1, 5};
        assertEquals(2, new Solution().numTimesAllBlue(a));
    }

    @Test
    void test3() {
        int[] a = {4, 1, 2, 3};
        assertEquals(1, new Solution().numTimesAllBlue(a));
    }

    @Test
    void test4() {
        int[] a = {2, 1, 4, 3, 6, 5};
        assertEquals(3, new Solution().numTimesAllBlue(a));
    }

    @Test
    void test5() {
        int[] a = {1, 2, 3, 4, 5, 6};
        assertEquals(6, new Solution().numTimesAllBlue(a));
    }
}