package leetcode.leetcode18xx.leetcode1871;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        assertTrue(new Solution().canReach("011010", 2, 3));
    }

    @Test
    void test2() {
        assertFalse(new Solution().canReach("01101110", 2, 3));
    }
}