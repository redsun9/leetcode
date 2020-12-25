package leetcode.leetcode16xx.leetcode1653;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(2, new Solution().minimumDeletions("aababbab"));
    }

    @Test
    void test2() {
        assertEquals(2, new Solution().minimumDeletions("bbaaaaabb"));
    }
}