package leetcode.leetcode87;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void isScramble() {
        Solution solution = new Solution();
        assertTrue(solution.isScramble("great", "rgeat"));
        assertFalse(solution.isScramble("abcde", "caebd"));
        assertTrue(solution.isScramble("abc", "bac"));
    }
}