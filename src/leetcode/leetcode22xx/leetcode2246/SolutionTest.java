package leetcode.leetcode22xx.leetcode2246;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] parent = {-1, 0, 0, 1, 1, 2};
        String s = "abacbe";
        assertEquals(3, new Solution().longestPath(parent, s));
    }

    @Test
    void test2() {
        int[] parent = {-1, 0, 0, 0};
        String s = "aabc";
        assertEquals(3, new Solution().longestPath(parent, s));
    }
}