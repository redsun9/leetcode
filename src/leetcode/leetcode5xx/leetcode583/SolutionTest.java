package leetcode.leetcode5xx.leetcode583;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(2, new Solution().minDistance("sea", "eat"));
    }

    @Test
    void test2() {
        assertEquals(4, new Solution().minDistance("leetcode", "etco"));
    }
}