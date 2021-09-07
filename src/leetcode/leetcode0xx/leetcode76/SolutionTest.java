package leetcode.leetcode0xx.leetcode76;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void minWindow() {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("BANC", solution2.minWindow("ADOBECODEBANC", "ABC"));

        assertEquals("baca", solution.minWindow("acbbaca", "aba"));
        assertEquals("baca", solution2.minWindow("acbbaca", "aba"));
    }
}