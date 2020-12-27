package leetcode.leetcode16xx.leetcode1665;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] tasks = {{1, 2}, {2, 4}, {4, 8}};
        assertEquals(8, new Solution().minimumEffort(tasks));
    }

    @Test
    void test2() {
        int[][] tasks = {{1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}};
        assertEquals(32, new Solution().minimumEffort(tasks));
    }
}