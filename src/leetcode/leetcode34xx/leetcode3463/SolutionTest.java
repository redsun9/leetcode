package leetcode.leetcode34xx.leetcode3463;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "31386065";
        boolean expected = true;
        assertEquals(expected, new Solution().hasSameDigits(s));
    }
}