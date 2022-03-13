package leetcode.leetcode21xx.leetcode2188;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] tires = {{2, 3}, {3, 4}};
        int changeTime = 5, numLaps = 4, expected = 21;
        assertEquals(expected, new Solution().minimumFinishTime(tires, changeTime, numLaps));
    }

    @Test
    void test2() {
        int[][] tires = {{1, 10}, {2, 2}, {3, 4}};
        int changeTime = 6, numLaps = 5, expected = 25;
        assertEquals(expected, new Solution().minimumFinishTime(tires, changeTime, numLaps));
    }
}