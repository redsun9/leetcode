package leetcode.leetcode7xx.leetcode790;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(5, new Solution().numTilings(3));
    }

    @Test
    void test2() {
        assertEquals(1, new Solution().numTilings(1));
    }

    @Test
    void test3() {
        assertEquals(2, new Solution().numTilings(2));
    }
}