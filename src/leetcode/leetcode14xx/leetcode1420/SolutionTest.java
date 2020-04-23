package leetcode.leetcode14xx.leetcode1420;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        assertEquals(6, solution.numOfArrays(2, 3, 1));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        assertEquals(0, solution.numOfArrays(5, 2, 3));
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        assertEquals(1, solution.numOfArrays(9, 1, 1));
    }

    @Test
    @org.junit.jupiter.api.Disabled
    void test4() {
        Solution solution = new Solution();
        assertEquals(34549172, solution.numOfArrays(50, 100, 25));
    }

    @Test
    @org.junit.jupiter.api.Disabled
    void test5() {
        Solution solution = new Solution();
        assertEquals(418930126, solution.numOfArrays(37, 17, 7));
    }
}