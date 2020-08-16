package leetcode.leetcode15xx.leetcode1553;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(4, new Solution().minDays(10));
    }

    @Test
    void test2() {
        assertEquals(3, new Solution().minDays(6));
    }

    @Test
    void test3() {
        assertEquals(1, new Solution().minDays(1));
    }

    @Test
    void test4() {
        assertEquals(6, new Solution().minDays(56));
    }

    @Test
    void test5() {
        assertEquals(34, new Solution().minDays(859858811));
    }
}