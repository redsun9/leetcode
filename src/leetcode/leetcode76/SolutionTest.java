package leetcode.leetcode76;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void minWindow() {
        Solution solution = new Solution();
        assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("baca", solution.minWindow("acbbaca", "aba"));
    }
}