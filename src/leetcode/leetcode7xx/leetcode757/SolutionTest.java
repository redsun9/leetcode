package leetcode.leetcode7xx.leetcode757;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] intervals = {{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        assertEquals(3, new Solution().intersectionSizeTwo(intervals));
    }

    @Test
    void test2() {
        int[][] intervals = {{12, 19}, {18, 25}, {4, 6}, {19, 24}, {19, 22}};
        assertEquals(5, new Solution().intersectionSizeTwo(intervals));
    }
}