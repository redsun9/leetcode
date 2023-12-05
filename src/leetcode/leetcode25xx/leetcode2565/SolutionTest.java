package leetcode.leetcode25xx.leetcode2565;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void minimumScore() {
        String s = "abacaba", t = "bzaa";
        assertEquals(1, new Solution().minimumScore(s, t));
    }
}