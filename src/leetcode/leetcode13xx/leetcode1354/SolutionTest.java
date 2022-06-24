package leetcode.leetcode13xx.leetcode1354;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] target = {9, 3, 5};
        assertTrue(new Solution().isPossible(target));
    }

    @Test
    void test2() {
        int[] target = {1, 1, 10};
        assertFalse(new Solution().isPossible(target));
    }
}