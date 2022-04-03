package leetcode.leetcode18xx.leetcode1896;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test1() {
        assertEquals(1, new Solution().minOperationsToFlip("1&(0|1)"));
    }

    @Test
    void test2() {
        assertEquals(3, new Solution().minOperationsToFlip("(0&0)&(0&0&0)"));
    }

    @Test
    void test3() {
        assertEquals(1, new Solution().minOperationsToFlip("(0|(1|0&1))"));
    }
}