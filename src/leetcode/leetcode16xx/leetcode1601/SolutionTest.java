package leetcode.leetcode16xx.leetcode1601;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int n = 5;
        int[][] transfers = {{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}};
        assertEquals(5, new Solution().maximumRequests(n, transfers));
    }

    @Test
    void test2() {
        int n = 3;
        int[][] transfers = {{0, 0}, {1, 2}, {2, 1}};
        assertEquals(3, new Solution().maximumRequests(n, transfers));
    }

    @Test
    void test3() {
        int n = 4;
        int[][] transfers = {{0, 3}, {3, 1}, {1, 2}, {2, 0}};
        assertEquals(4, new Solution().maximumRequests(n, transfers));
    }
}