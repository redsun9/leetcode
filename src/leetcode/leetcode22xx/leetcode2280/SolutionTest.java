package leetcode.leetcode22xx.leetcode2280;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] arr = {{36, 9}, {17, 93}, {34, 4}, {30, 11}, {11, 41}, {53, 36}, {5, 92}, {81, 92}, {28, 36}, {3, 45}, {72, 33}, {64, 1}, {4, 70}, {16, 73}, {99, 20}, {49, 33}, {47, 74}, {83, 91}};
        assertEquals(17, new Solution().minimumLines(arr));
    }
}