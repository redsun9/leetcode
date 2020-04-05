package leetcode.leetcode13xx.leetcode1307;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        assertTrue(solution.isSolvable(new String[]{"SEND", "MORE"}, "MONEY"));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        assertTrue(solution.isSolvable(new String[]{"SIX", "SEVEN", "SEVEN"}, "TWENTY"));
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        assertTrue(solution.isSolvable(new String[]{"THIS", "IS", "TOO"}, "FUNNY"));
    }

    @Test
    void test4() {
        Solution solution = new Solution();
        assertFalse(solution.isSolvable(new String[]{"LEET", "CODE"}, "POINT"));
    }

    @Test
    void test5() {
        Solution solution = new Solution();
        assertTrue(solution.isSolvable(new String[]{"BUT", "ITS", "STILL"}, "FUNNY"));
    }
}
