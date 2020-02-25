package leetcode.leetcode1363;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void largestMultipleOfThree() {
        Solution solution = new Solution();
        assertEquals("981", solution.largestMultipleOfThree(new int[]{8, 1, 9}));
        assertEquals("8760", solution.largestMultipleOfThree(new int[]{8, 6, 7, 1, 0}));
        assertEquals("", solution.largestMultipleOfThree(new int[]{1}));
        assertEquals("0", solution.largestMultipleOfThree(new int[]{0, 0, 0, 0, 0, 0}));
    }
}