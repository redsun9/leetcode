package leetcode.leetcode5xx.leetcode576;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(6, new Solution().findPaths(2, 2, 2, 0, 0));
    }

    @Test
    void test2() {
        assertEquals(12, new Solution().findPaths(1, 3, 3, 0, 1));
    }
}