package leetcode.leetcode16xx.leetcode1643;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] destination = {2, 3};
        assertEquals("HHHVV", new Solution().kthSmallestPath(destination, 1));
    }

    @Test
    void test2() {
        int[] destination = {2, 3};
        assertEquals("HHVHV", new Solution().kthSmallestPath(destination, 2));
    }

    @Test
    void test3() {
        int[] destination = {2, 3};
        assertEquals("HHVVH", new Solution().kthSmallestPath(destination, 3));
    }
}