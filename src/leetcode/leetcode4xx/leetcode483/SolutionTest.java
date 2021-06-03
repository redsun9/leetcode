package leetcode.leetcode4xx.leetcode483;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("3", new Solution().smallestGoodBase("13"));
    }

    @Test
    void test2() {
        assertEquals("8", new Solution().smallestGoodBase("4681"));
    }

    @Test
    void test3() {
        assertEquals("999999999999999999", new Solution().smallestGoodBase("1000000000000000000"));
    }
}