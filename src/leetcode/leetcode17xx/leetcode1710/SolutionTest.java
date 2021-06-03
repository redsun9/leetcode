package leetcode.leetcode17xx.leetcode1710;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        int expected = 8;
        assertEquals(expected, new Solution().maximumUnits(boxTypes, truckSize));
        assertEquals(expected, new Solution2().maximumUnits(boxTypes, truckSize));
    }

    @Test
    void test2() {
        int[][] boxTypes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize = 10;
        int expected = 91;
        assertEquals(expected, new Solution().maximumUnits(boxTypes, truckSize));
        assertEquals(expected, new Solution2().maximumUnits(boxTypes, truckSize));
    }
}