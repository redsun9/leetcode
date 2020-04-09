package leetcode.leetcode8xx.leetcode844;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        assertTrue(solution.backspaceCompare("ab#c", "ad#c"));
        assertTrue(solution.backspaceCompare("ab##", "c#d#"));
        assertTrue(solution.backspaceCompare("a##c", "#a#c"));
        assertFalse(solution.backspaceCompare("a#c", "b"));
    }
}