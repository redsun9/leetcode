package leetcode.leetcode16xx.leetcode1652;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] code = {5, 7, 1, 4};
        int[] expected = {12, 10, 16, 13};
        assertArrayEquals(expected, new Solution().decrypt(code, 3));
    }

    @Test
    void test2() {
        int[] code = {1, 2, 3, 4};
        int[] expected = {0, 0, 0, 0};
        assertArrayEquals(expected, new Solution().decrypt(code, 0));
    }

    @Test
    void test3() {
        int[] code = {2, 4, 9, 3};
        int[] expected = {12, 5, 6, 13};
        assertArrayEquals(expected, new Solution().decrypt(code, -2));
    }
}