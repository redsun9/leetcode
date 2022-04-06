package leetcode.leetcode16xx.leetcode1691;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] cuboids = {{50, 45, 20}, {95, 37, 53}, {45, 23, 12}};
        assertEquals(190, new Solution().maxHeight(cuboids));
    }

    @Test
    void test2() {
        int[][] cuboids = {{38, 25, 45}, {76, 35, 3}};
        assertEquals(76, new Solution().maxHeight(cuboids));
    }

    @Test
    void test3() {
        int[][] cuboids = {{7, 11, 17}, {7, 17, 11}, {11, 7, 17}, {11, 17, 7}, {17, 7, 11}, {17, 11, 7}};
        assertEquals(102, new Solution().maxHeight(cuboids));
    }
}