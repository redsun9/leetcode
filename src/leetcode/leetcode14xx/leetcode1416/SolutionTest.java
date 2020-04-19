package leetcode.leetcode14xx.leetcode1416;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        assertEquals(1, solution.numberOfArrays("1000", 10000));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        assertEquals(0, solution.numberOfArrays("1000", 10));
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        assertEquals(8, solution.numberOfArrays("1317", 2000));
    }

    @Test
    void test4() {
        Solution solution = new Solution();
        assertEquals(1, solution.numberOfArrays("2020", 30));
    }

    @Test
    void test5() {
        Solution solution = new Solution();
        assertEquals(34, solution.numberOfArrays("1234567890", 90));
    }
}