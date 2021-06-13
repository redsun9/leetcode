package leetcode.leetcode18xx.leetcode1898;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "abcacb", p = "ab";
        int[] removable = {3, 1, 0};
        assertEquals(2, new Solution().maximumRemovals(s, p, removable));
    }

    @Test
    void test2() {
        String s = "abcbddddd", p = "abcd";
        int[] removable = {3, 2, 1, 4, 5, 6};
        assertEquals(1, new Solution().maximumRemovals(s, p, removable));
    }

    @Test
    void test3() {
        String s = "abcab", p = "abc";
        int[] removable = {0, 1, 2, 3, 4};
        assertEquals(0, new Solution().maximumRemovals(s, p, removable));
    }
}