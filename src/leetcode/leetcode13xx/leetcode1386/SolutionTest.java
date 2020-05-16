package leetcode.leetcode13xx.leetcode1386;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] seats = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        assertEquals(4, new Solution().maxNumberOfFamilies(3, seats));
    }
}