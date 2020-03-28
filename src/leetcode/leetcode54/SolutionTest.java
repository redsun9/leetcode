package leetcode.leetcode54;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void spiralOrder() {
        Solution solution = new Solution();
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        assertEquals(expected, solution.spiralOrder(a));
    }
}