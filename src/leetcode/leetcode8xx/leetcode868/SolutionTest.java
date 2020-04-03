package leetcode.leetcode8xx.leetcode868;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void binaryGap() {
        Solution solution = new Solution();
        assertEquals(2, solution.binaryGap(5));
        assertEquals(1, solution.binaryGap(6));
        assertEquals(0, solution.binaryGap(0));
    }
}