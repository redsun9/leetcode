package leetcode.leetcode22xx.leetcode2209;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String floor = "10110101";
        int numCarpets = 2, carpetLen = 2, expected = 2;
        assertEquals(expected, new Solution().minimumWhiteTiles(floor, numCarpets, carpetLen));
    }

    @Test
    void test2() {
        String floor = "11111";
        int numCarpets = 2, carpetLen = 3, expected = 0;
        assertEquals(expected, new Solution().minimumWhiteTiles(floor, numCarpets, carpetLen));
    }

    @Test
    void test3() {
        String floor = "111111111111";
        int numCarpets = 9, carpetLen = 1, expected = 3;
        assertEquals(expected, new Solution().minimumWhiteTiles(floor, numCarpets, carpetLen));
    }
}