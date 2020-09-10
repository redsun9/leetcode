package leetcode.leetcode1xx.leetcode165;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(-1, new Solution().compareVersion("0.1", "1.1"));
    }

    @Test
    void test2() {
        assertEquals(1, new Solution().compareVersion("1.0.1", "1"));
    }

    @Test
    void test3() {
        assertEquals(-1, new Solution().compareVersion("7.5.2.4", "7.5.3"));
    }

    @Test
    void test4() {
        assertEquals(0, new Solution().compareVersion("1.01", "1.001"));
    }

    @Test
    void test5() {
        assertEquals(0, new Solution().compareVersion("1.0", "1.0.0"));
    }
}