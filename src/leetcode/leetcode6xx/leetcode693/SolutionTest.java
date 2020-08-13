package leetcode.leetcode6xx.leetcode693;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        assertTrue(new Solution().hasAlternatingBits(5));
    }

    @Test
    void test2() {
        assertFalse(new Solution().hasAlternatingBits(7));
    }

    @Test
    void test3() {
        assertFalse(new Solution().hasAlternatingBits(11));
    }

    @Test
    void test4() {
        assertTrue(new Solution().hasAlternatingBits(10));
    }
}
