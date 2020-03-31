package leetcode.leetcode2xx.leetcode239;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void testSliding() {
        Solution solution = new Solution();
        assertArrayEquals(
                new int[]{3, 3, 5, 5, 6, 7},
                solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)
        );
    }

    @Test
    void testByOne() {
        Solution solution = new Solution();
        assertArrayEquals(
                new int[]{1, 3, -1, -3, 5, 3, 6, 7},
                solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 1)
        );
    }

    @Test
    void testByAll() {
        Solution solution = new Solution();
        assertArrayEquals(
                new int[]{7},
                solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 8)
        );
    }

}