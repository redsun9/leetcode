package leetcode.leetcode4xx.leetcode473;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] matchsticks = {1, 1, 2, 2, 2};
        assertTrue(new Solution().makesquare(matchsticks));
    }

    @Test
    void test2() {
        int[] matchsticks = {3, 3, 3, 3, 4};
        assertFalse(new Solution().makesquare(matchsticks));
    }
}