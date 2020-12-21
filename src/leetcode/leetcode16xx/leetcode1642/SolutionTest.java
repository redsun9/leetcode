package leetcode.leetcode16xx.leetcode1642;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        assertEquals(4, new Solution().furthestBuilding(heights, 5, 1));
    }

    @Test
    void test2() {
        int[] heights = {4, 12, 2, 7, 3, 18, 20, 3, 19};
        assertEquals(7, new Solution().furthestBuilding(heights, 10, 2));
    }

    @Test
    void test3() {
        int[] heights = {14, 3, 19, 3};
        assertEquals(3, new Solution().furthestBuilding(heights, 17, 0));
    }
}