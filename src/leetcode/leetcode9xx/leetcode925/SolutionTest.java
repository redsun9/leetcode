package leetcode.leetcode9xx.leetcode925;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        assertTrue(new Solution().isLongPressedName("alex", "aaleex"));
        assertFalse(new Solution().isLongPressedName("saeed", "ssaaedd"));
        assertTrue(new Solution().isLongPressedName("leelee", "lleeelee"));
        assertTrue(new Solution().isLongPressedName("laiden", "laiden"));
    }
}