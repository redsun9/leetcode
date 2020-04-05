package leetcode.leetcode12xx.leetcode1201;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void nthUglyNumber() {
        Solution solution = new Solution();
        assertEquals(4, solution.nthUglyNumber(3, 2, 3, 5));
        assertEquals(6, solution.nthUglyNumber(4, 2, 3, 4));
        assertEquals(10, solution.nthUglyNumber(5, 2, 11, 13));
        assertEquals(1999999984, solution.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }
}