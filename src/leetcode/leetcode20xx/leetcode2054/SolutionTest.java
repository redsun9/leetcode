package leetcode.leetcode20xx.leetcode2054;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] events = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        assertEquals(4, new Solution().maxTwoEvents(events));
    }

    @Test
    void test2() {
        int[][] events = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}};
        assertEquals(5, new Solution().maxTwoEvents(events));
    }

    @Test
    void test3() {
        int[][] events = {{1, 5, 3}, {1, 5, 1}, {6, 6, 5}};
        assertEquals(8, new Solution().maxTwoEvents(events));
    }
}