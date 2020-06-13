package leetcode.leetcode14xx.leetcode1478;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] houses = {1, 4, 8, 10, 20};
        assertEquals(5, new Solution().minDistance(houses, 3));
    }

    @Test
    void test2() {
        int[] houses = {2, 3, 5, 12, 18};
        assertEquals(9, new Solution().minDistance(houses, 2));
    }

    @Test
    void test3() {
        int[] houses = {7, 4, 6, 1};
        assertEquals(8, new Solution().minDistance(houses, 1));
    }

    @Test
    void test4() {
        int[] houses = {3, 6, 14, 10};
        assertEquals(0, new Solution().minDistance(houses, 4));
    }

}