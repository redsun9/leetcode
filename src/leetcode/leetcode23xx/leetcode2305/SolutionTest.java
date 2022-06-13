package leetcode.leetcode23xx.leetcode2305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test1() {
        int[] cookies = {8, 15, 10, 20, 8};
        int k = 2;
        int expected = 31;
        assertEquals(expected, new Solution().distributeCookies(cookies, k));
    }

    @Test
    void test2() {
        int[] cookies = {6, 1, 3, 2, 2, 4, 1, 2};
        int k = 3;
        int expected = 7;
        assertEquals(expected, new Solution().distributeCookies(cookies, k));
    }
}