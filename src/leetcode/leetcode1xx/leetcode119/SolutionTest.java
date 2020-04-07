package leetcode.leetcode1xx.leetcode119;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void getRow() {
        Solution solution = new Solution();
        assertEquals(Arrays.asList(1, 3, 3, 1), solution.getRow(3));
    }
}