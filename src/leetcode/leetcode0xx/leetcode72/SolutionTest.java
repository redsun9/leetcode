package leetcode.leetcode0xx.leetcode72;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(3, new Solution().minDistance("horse", "ros"));
        assertEquals(3, new Solution2().minDistance("horse", "ros"));
    }
}