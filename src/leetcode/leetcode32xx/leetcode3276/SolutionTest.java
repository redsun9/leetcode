package leetcode.leetcode32xx.leetcode3276;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        List<List<Integer>> grid = List.of(List.of(1, 2, 3), List.of(4, 3, 2), List.of(1, 1, 1));
        assertEquals(8, new Solution().maxScore(grid));
    }

    @Test
    void test2() {
        List<List<Integer>> grid = List.of(List.of(8, 7, 6), List.of(8, 3, 2));
        assertEquals(15, new Solution().maxScore(grid));
    }
}