package leetcode.leetcode19xx.leetcode1987;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(2, new Solution().numberOfUniqueGoodSubsequences("001"));
    }

    @Test
    void test2() {
        assertEquals(2, new Solution().numberOfUniqueGoodSubsequences("11"));
    }

    @Test
    void test3() {
        assertEquals(5, new Solution().numberOfUniqueGoodSubsequences("101"));
    }
}