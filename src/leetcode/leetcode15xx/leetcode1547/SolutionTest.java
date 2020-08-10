package leetcode.leetcode15xx.leetcode1547;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] cuts = {1, 3, 4, 5};
        assertEquals(16, new Solution().minCost(7, cuts));
    }

    @Test
    void test2() {
        int[] cuts = {5, 6, 1, 4, 2};
        assertEquals(22, new Solution().minCost(9, cuts));
    }
}