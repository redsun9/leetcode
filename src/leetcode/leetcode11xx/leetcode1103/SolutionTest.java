package leetcode.leetcode11xx.leetcode1103;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        assertArrayEquals(new int[]{1, 2, 3, 1}, new Solution().distributeCandies(7, 4));
    }

    @Test
    void test2() {
        assertArrayEquals(new int[]{5, 2, 3}, new Solution().distributeCandies(10, 3));
    }
}