package leetcode.leetcode18xx.leetcode1889;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] packages = {2, 3, 5};
        int[][] boxes = {{4, 8}, {2, 8}};
        assertEquals(6, new Solution().minWastedSpace(packages, boxes));
    }

    @Test
    void test2() {
        int[] packages = {2, 3, 5};
        int[][] boxes = {{1, 4}, {2, 3}, {3, 4}};
        assertEquals(-1, new Solution().minWastedSpace(packages, boxes));
    }

    @Test
    void test3() {
        int[] packages = {3, 5, 8, 10, 11, 12};
        int[][] boxes = {{12}, {11, 9}, {10, 5, 14}};
        assertEquals(9, new Solution().minWastedSpace(packages, boxes));
    }
}