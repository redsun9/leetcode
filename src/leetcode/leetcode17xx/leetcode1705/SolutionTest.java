package leetcode.leetcode17xx.leetcode1705;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] apples = {1, 2, 3, 5, 2};
        int[] days = {3, 2, 1, 4, 2};
        assertEquals(7, new Solution().eatenApples(apples, days));
    }

    @Test
    void test2() {
        int[] apples = {3, 0, 0, 0, 0, 2};
        int[] days = {3, 0, 0, 0, 0, 2};
        assertEquals(5, new Solution().eatenApples(apples, days));
    }
}