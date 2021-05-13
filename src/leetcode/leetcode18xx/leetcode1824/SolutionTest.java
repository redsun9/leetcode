package leetcode.leetcode18xx.leetcode1824;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] obstacles = {0, 1, 2, 3, 0};
        assertEquals(2, new Solution().minSideJumps(obstacles));
    }

    @Test
    void test2() {
        int[] obstacles = {0, 1, 1, 3, 3, 0};
        assertEquals(0, new Solution().minSideJumps(obstacles));
    }

    @Test
    void test3() {
        int[] obstacles = {0, 2, 1, 0, 3, 0};
        assertEquals(2, new Solution().minSideJumps(obstacles));
    }
}