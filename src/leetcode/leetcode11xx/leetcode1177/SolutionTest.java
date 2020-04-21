package leetcode.leetcode11xx.leetcode1177;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void canMakePaliQueries() {
        Solution solution = new Solution();
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        assertEquals(
                Arrays.asList(true, false, false, true, true),
                solution.canMakePaliQueries("abcda", queries)
        );
    }
}