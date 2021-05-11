package leetcode.leetcode18xx.leetcode1849;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        assertFalse(new Solution().splitString("1234"));
    }

    @Test
    void test2() {
        assertTrue(new Solution().splitString("050043"));
    }

    @Test
    void test3() {
        assertFalse(new Solution().splitString("9080701"));
    }

    @Test
    void test4() {
        assertTrue(new Solution().splitString("10009998"));
    }
}