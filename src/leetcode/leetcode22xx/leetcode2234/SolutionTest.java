package leetcode.leetcode22xx.leetcode2234;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] flowers = {1, 3, 1, 1};
        int newFlowers = 7, target = 6, full = 12, partial = 1, expected = 14;
        assertEquals(expected, new Solution().maximumBeauty(flowers, newFlowers, target, full, partial));
    }

    @Test
    void test2() {
        int[] flowers = {2, 4, 5, 3};
        int newFlowers = 10, target = 5, full = 2, partial = 6, expected = 30;
        assertEquals(expected, new Solution().maximumBeauty(flowers, newFlowers, target, full, partial));
    }

    @Test
    void test3() {
        int[] flowers = {8, 2};
        int newFlowers = 24, target = 18, full = 6, partial = 3, expected = 54;
        assertEquals(expected, new Solution().maximumBeauty(flowers, newFlowers, target, full, partial));
    }
}