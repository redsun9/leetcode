package leetcode.leetcode18xx.leetcode1860;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] expected = {3, 1, 0};
        assertArrayEquals(expected, new Solution().memLeak(2, 2));
    }

    @Test
    void test2() {
        int[] expected = {2, 1, 0};
        assertArrayEquals(expected, new Solution().memLeak(2, 0));
    }

    @Test
    void test3() {
        int[] expected = {4, 2, 1};
        assertArrayEquals(expected, new Solution().memLeak(8, 1));
    }

    @Test
    void test4() {
        int[] expected = {6, 0, 4};
        assertArrayEquals(expected, new Solution().memLeak(8, 11));
    }
}