package leetcode.leetcode13xx.leetcode1388;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] slices = {1, 2, 3, 4, 5, 6};
        assertEquals(10, new Solution().maxSizeSlices(slices));
    }

    @Test
    void test2() {
        int[] slices = {8, 9, 8, 6, 1, 1};
        assertEquals(16, new Solution().maxSizeSlices(slices));
    }

    @Test
    void test3() {
        int[] slices = {4, 1, 2, 5, 8, 3, 1, 9, 7};
        assertEquals(21, new Solution().maxSizeSlices(slices));
    }

    @Test
    void test4() {
        int[] slices = {3, 1, 2};
        assertEquals(3, new Solution().maxSizeSlices(slices));
    }
}