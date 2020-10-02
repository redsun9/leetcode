package leetcode.leetcode7xx.leetcode761;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("11100100", new Solution().makeLargestSpecial("11011000"));
        assertEquals("11100100", new Solution2().makeLargestSpecial("11011000"));
    }
}