package leetcode.leetcode3xx.leetcode327;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        assertEquals(3, solution.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }
}