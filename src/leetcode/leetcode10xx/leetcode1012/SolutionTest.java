package leetcode.leetcode10xx.leetcode1012;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test() {
        assertEquals(1, new Solution().numDupDigitsAtMostN(20));
        assertEquals(10, new Solution().numDupDigitsAtMostN(100));
        assertEquals(262, new Solution().numDupDigitsAtMostN(1000));
    }
}