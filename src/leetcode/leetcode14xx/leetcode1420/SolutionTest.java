package leetcode.leetcode14xx.leetcode1420;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();
    Solution2 solution2 = new Solution2();

    @Test
    void test1() {
        assertEquals(6, solution.numOfArrays(2, 3, 1));
        assertEquals(6, solution2.numOfArrays(2, 3, 1));
    }

    @Test
    void test2() {
        assertEquals(0, solution.numOfArrays(5, 2, 3));
        assertEquals(0, solution2.numOfArrays(5, 2, 3));
    }

    @Test
    void test3() {
        assertEquals(1, solution.numOfArrays(9, 1, 1));
        assertEquals(1, solution2.numOfArrays(9, 1, 1));
    }

    @Test
    void test4() {
        assertEquals(34549172, solution.numOfArrays(50, 100, 25));
        assertEquals(34549172, solution2.numOfArrays(50, 100, 25));
    }

    @Test
    void test5() {
        assertEquals(418930126, solution.numOfArrays(37, 17, 7));
        assertEquals(418930126, solution2.numOfArrays(37, 17, 7));
    }
}