package leetcode.leetcode0xx.leetcode33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        assertEquals(4, solution.search(new int[]{3, 4, 5, 6, 7, 8, 1, 2}, 7));
    }
}