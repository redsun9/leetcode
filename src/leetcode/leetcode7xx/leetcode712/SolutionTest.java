package leetcode.leetcode7xx.leetcode712;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s1 = "sea", s2 = "eat";
        assertEquals(231, new Solution().minimumDeleteSum(s1, s2));
        assertEquals(231, new Solution2().minimumDeleteSum(s1, s2));
    }

    @Test
    void test2() {
        String s1 = "delete", s2 = "leet";
        assertEquals(403, new Solution().minimumDeleteSum(s1, s2));
        assertEquals(403, new Solution2().minimumDeleteSum(s1, s2));
    }
}