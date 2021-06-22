package leetcode.leetcode6xx.leetcode629;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(1, new Solution().kInversePairs(3, 0));
        assertEquals(2, new Solution().kInversePairs(3, 1));
        assertEquals(663677020, new Solution().kInversePairs(1000, 1000));
    }
}